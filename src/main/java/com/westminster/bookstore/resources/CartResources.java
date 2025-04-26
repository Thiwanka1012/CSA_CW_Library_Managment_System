package com.westminster.bookstore.resources;

import com.westminster.bookstore.dao.BookDAO;
import com.westminster.bookstore.dao.CartDAO;
import com.westminster.bookstore.dao.CustomerDAO;
import com.westminster.bookstore.exceptions.BookNotFoundException;
import com.westminster.bookstore.exceptions.CartNotFoundException;
import com.westminster.bookstore.exceptions.CustomerNotFoundException;
import com.westminster.bookstore.exceptions.InvalidInputException;
import com.westminster.bookstore.exceptions.OutOfStockException;
import com.westminster.bookstore.model.Book;
import com.westminster.bookstore.model.Cart;
import com.westminster.bookstore.model.CartItem;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Path("/customers/{customerId}/cart")
public class CartResources {
    private CartDAO cartDAO = new CartDAO();
    private CustomerDAO customerDAO = new CustomerDAO();
    private BookDAO bookDAO = new BookDAO();

    @POST
    @Path("/items")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addItemToCart(@PathParam("customerId") int customerId, CartItem cartItem) {
        // Validate customer exists
        if (customerDAO.getCustomerById(customerId) == null) {
            throw new CustomerNotFoundException("Customer with ID " + customerId + " not found");
        }

        // Validate book exists
        Book book = bookDAO.getBookById(cartItem.getBookId());
        if (book == null) {
            throw new BookNotFoundException("Book with ID " + cartItem.getBookId() + " not found");
        }

        // Validate quantity
        if (cartItem.getQuantity() <= 0) {
            throw new InvalidInputException("Quantity must be greater than zero");
        }

        // Check stock availability
        if (book.getStockQuantity() < cartItem.getQuantity()) {
            throw new OutOfStockException("Requested quantity " + cartItem.getQuantity() + " exceeds available stock for book ID " + cartItem.getBookId());
        }

        // Add item to cart
        cartDAO.addItemToCart(customerId, cartItem);
        Cart cart = cartDAO.getCartByCustomerId(customerId);

        // Build response with totalPrice
        Map<String, Object> response = new HashMap<>();
        response.put("customerId", cart.getCustomerId());
        response.put("items", cart.getItems());
        response.put("totalPrice", cart.getTotalPrice());

        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCart(@PathParam("customerId") int customerId) {
        // Validate customer exists
        if (customerDAO.getCustomerById(customerId) == null) {
            throw new CustomerNotFoundException("Customer with ID " + customerId + " not found");
        }

        Cart cart = cartDAO.getCartByCustomerId(customerId);
        if (cart == null) {
            throw new CartNotFoundException("Cart for customer ID " + customerId + " not found");
        }

        // Build response with totalPrice
        Map<String, Object> response = new HashMap<>();
        response.put("customerId", cart.getCustomerId());
        response.put("items", cart.getItems());
        response.put("totalPrice", cart.getTotalPrice());

        return Response.ok(response).build();
    }

    @PUT
    @Path("/items/{bookId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCartItem(@PathParam("customerId") int customerId, @PathParam("bookId") int bookId, CartItem updatedItem) {
        // Validate customer exists
        if (customerDAO.getCustomerById(customerId) == null) {
            throw new CustomerNotFoundException("Customer with ID " + customerId + " not found");
        }

        // Validate book exists
        Book book = bookDAO.getBookById(bookId);
        if (book == null) {
            throw new BookNotFoundException("Book with ID " + bookId + " not found");
        }

        // Validate quantity
        if (updatedItem.getQuantity() <= 0) {
            throw new InvalidInputException("Quantity must be greater than zero");
        }

        // Check stock availability
        if (book.getStockQuantity() < updatedItem.getQuantity()) {
            throw new OutOfStockException("Requested quantity " + updatedItem.getQuantity() + " exceeds available stock for book ID " + bookId);
        }

        // Update item in cart
        updatedItem.setBookId(bookId);
        cartDAO.updateCartItem(customerId, updatedItem);
        Cart cart = cartDAO.getCartByCustomerId(customerId);

        // Build response with totalPrice
        Map<String, Object> response = new HashMap<>();
        response.put("customerId", cart.getCustomerId());
        response.put("items", cart.getItems());
        response.put("totalPrice", cart.getTotalPrice());

        return Response.ok(response).build();
    }

    @DELETE
    @Path("/items/{bookId}")
    public Response removeItemFromCart(@PathParam("customerId") int customerId, @PathParam("bookId") int bookId) {
        // Validate customer exists
        if (customerDAO.getCustomerById(customerId) == null) {
            throw new CustomerNotFoundException("Customer with ID " + customerId + " not found");
        }

        // Validate book exists
        if (bookDAO.getBookById(bookId) == null) {
            throw new BookNotFoundException("Book with ID " + bookId + " not found");
        }

        // Remove item from cart
        cartDAO.removeItemFromCart(customerId, bookId);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    // Temporary endpoint to clear carts for testing
    @DELETE
    @Path("/clear")
    public Response clearCarts() {
        cartDAO.clearCarts();
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}