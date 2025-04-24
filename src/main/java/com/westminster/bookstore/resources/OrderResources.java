package com.westminster.bookstore.resources;

import com.westminster.bookstore.storage.OrderDAO;
import com.westminster.bookstore.model.Order;
import com.westminster.bookstore.exceptions.OrderNotFoundException;
import com.westminster.bookstore.exceptions.InvalidInputException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Path("/orders")
public class OrderResources {
    private OrderDAO orderDAO = new OrderDAO();

    // Create a new order
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createOrder(Order order) {
        // Validate input
        if (order.getCustomerId() <= 0) {
            throw new InvalidInputException("Customer ID must be a positive integer");
        }
        if (order.getItems() == null || order.getItems().isEmpty()) {
            throw new InvalidInputException("Order items cannot be empty");
        }
        for (Map.Entry<Integer, Integer> entry : order.getItems().entrySet()) {
            if (entry.getKey() <= 0 || entry.getValue() <= 0) {
                throw new InvalidInputException("Book ID and quantity must be positive integers");
            }
        }
        if (order.getTotalPrice() <= 0) {
            throw new InvalidInputException("Total price must be greater than zero");
        }
        if (order.getOrderDate() == null) {
            order.setOrderDate(LocalDateTime.now());
        }

        orderDAO.addOrder(order);
        return Response.status(Response.Status.CREATED).entity(order).build();
    }

    // Get all orders
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Order> getAllOrders() {
        return orderDAO.getAllOrders();
    }

    // Get order by ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrderById(@PathParam("id") int id) {
        Order order = orderDAO.getOrderById(id);
        if (order == null) {
            throw new OrderNotFoundException("Order with ID " + id + " not found");
        }
        return Response.ok(order).build();
    }

    // Update an existing order
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateOrder(@PathParam("id") int id, Order updatedOrder) {
        Order existingOrder = orderDAO.getOrderById(id);
        if (existingOrder == null) {
            throw new OrderNotFoundException("Order with ID " + id + " not found");
        }

        // Validate input
        if (updatedOrder.getCustomerId() <= 0) {
            throw new InvalidInputException("Customer ID must be a positive integer");
        }
        if (updatedOrder.getItems() == null || updatedOrder.getItems().isEmpty()) {
            throw new InvalidInputException("Order items cannot be empty");
        }
        for (Map.Entry<Integer, Integer> entry : updatedOrder.getItems().entrySet()) {
            if (entry.getKey() <= 0 || entry.getValue() <= 0) {
                throw new InvalidInputException("Book ID and quantity must be positive integers");
            }
        }
        if (updatedOrder.getTotalPrice() <= 0) {
            throw new InvalidInputException("Total price must be greater than zero");
        }
        if (updatedOrder.getOrderDate() == null) {
            updatedOrder.setOrderDate(existingOrder.getOrderDate());
        }

        updatedOrder.setOrderId(id);
        orderDAO.updateOrder(updatedOrder);
        return Response.ok(updatedOrder).build();
    }

    // Delete an order
    @DELETE
    @Path("/{id}")
    public Response deleteOrder(@PathParam("id") int id) {
        Order order = orderDAO.getOrderById(id);
        if (order == null) {
            throw new OrderNotFoundException("Order with ID " + id + " not found");
        }
        orderDAO.deleteOrder(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}