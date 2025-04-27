package com.westminster.bookstore.resources;

import com.westminster.bookstore.dao.BookDAO;
import com.westminster.bookstore.dao.CartDAO;
import com.westminster.bookstore.dao.CustomerDAO;
import com.westminster.bookstore.dao.OrderDAO;
import com.westminster.bookstore.exceptions.*;
import com.westminster.bookstore.model.Book;
import com.westminster.bookstore.model.Cart;
import com.westminster.bookstore.model.CartItem;
import com.westminster.bookstore.model.Order;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/customers/{customerId}/orders")
public class OrderResources {
    private OrderDAO orderDAO = new OrderDAO();
    private CustomerDAO customerDAO = new CustomerDAO();
    private BookDAO bookDAO = new BookDAO();
    private CartDAO cartDAO = new CartDAO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createOrder(@PathParam("customerId") int customerId) {
        // Validate customer exists
        if (customerDAO.getCustomerById(customerId) == null) {
            throw new CustomerNotFoundException("Customer with ID " + customerId + " not found");
        }

        // Get the cart
        Cart cart = cartDAO.getCartByCustomerId(customerId);
        if (cart.getItems() == null || cart.getItems().isEmpty()) {
            throw new InvalidInputException("Cart is empty. Add items to cart before placing an order.");
        }

        // Validate items and calculate total price
        Map<Integer, Integer> orderItems = new HashMap<>();
        double totalPrice = 0.0;
        for (CartItem item : cart.getItems()) {
            int bookId = item.getBookId();
            int quantity = item.getQuantity();

            // Validate book exists
            Book book = bookDAO.getBookById(bookId);
            if (book == null) {
                throw new BookNotFoundException("Book with ID " + bookId + " not found");
            }

            // Check stock availability
            if (book.getStockQuantity() < quantity) {
                throw new OutOfStockException("Requested quantity " + quantity + " exceeds available stock for book ID " + bookId);
            }

            // Calculate price
            totalPrice += book.getPrice() * quantity;
            orderItems.put(bookId, quantity);

            // Update stock
            book.setStockQuantity(book.getStockQuantity() - quantity);
            bookDAO.updateBook(book);
        }

        // Create the order
        Order order = new Order();
        order.setCustomerId(customerId);
        order.setItems(orderItems);
        order.setTotalPrice(totalPrice);
        order.setOrderDate(LocalDateTime.now());
        Order createdOrder = orderDAO.addOrder(order);

        // Clear the cart after order is placed
        cartDAO.removeAllItemsFromCart(customerId);

        return Response.status(Response.Status.CREATED).entity(createdOrder).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrdersByCustomerId(@PathParam("customerId") int customerId) {
        // Validate customer exists
        if (customerDAO.getCustomerById(customerId) == null) {
            throw new CustomerNotFoundException("Customer with ID " + customerId + " not found");
        }

        List<Order> orders = orderDAO.getOrdersByCustomerId(customerId);
        return Response.ok(orders).build();
    }

    @GET
    @Path("/{orderId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrderById(@PathParam("customerId") int customerId, @PathParam("orderId") int orderId) {
        // Validate customer exists
        if (customerDAO.getCustomerById(customerId) == null) {
            throw new CustomerNotFoundException("Customer with ID " + customerId + " not found");
        }

        Order order = orderDAO.getOrderById(orderId);
        if (order == null || order.getCustomerId() != customerId) {
            throw new OrderNotFoundException("Order with ID " + orderId + " not found for customer ID " + customerId);
        }

        return Response.ok(order).build();
    }

    // Temporary endpoint to clear orders for testing
    @DELETE
    @Path("/clear")
    @Produces(MediaType.APPLICATION_JSON)
    public Response clearOrders() {
        orderDAO.clearOrders();
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}