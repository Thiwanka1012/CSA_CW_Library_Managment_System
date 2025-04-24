package com.westminster.bookstore.resources;

import com.westminster.bookstore.dao.CartDAO;
import com.westminster.bookstore.model.Cart;
import com.westminster.bookstore.exceptions.CartNotFoundException;
import com.westminster.bookstore.exceptions.InvalidInputException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Map;

@Path("/carts")
public class CartResources {
    private CartDAO cartDAO = new CartDAO();

    // Create a new cart
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCart(Cart cart) {
        // Validate input
        if (cart.getCustomerId() <= 0) {
            throw new InvalidInputException("Customer ID must be a positive integer");
        }
        if (cart.getItem() == null || cart.getItem().isEmpty()) {
            throw new InvalidInputException("Cart items cannot be empty");
        }
        for (Map.Entry<Integer, Integer> entry : cart.getItem().entrySet()) {
            if (entry.getKey() <= 0 || entry.getValue() <= 0) {
                throw new InvalidInputException("Book ID and quantity must be positive integers");
            }
        }

        cartDAO.addCart(cart);
        return Response.status(Response.Status.CREATED).entity(cart).build();
    }

    // Get all carts
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cart> getAllCarts() {
        return cartDAO.getAllCarts();
    }

    // Get cart by customer ID
    @GET
    @Path("/{customerId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCartByCustomerId(@PathParam("customerId") int customerId) {
        if (customerId <= 0) {
            throw new InvalidInputException("Customer ID must be a positive integer");
        }
        Cart cart = cartDAO.getCartByCustomerId(customerId);
        if (cart == null) {
            throw new CartNotFoundException("Cart for customer with ID " + customerId + " not found");
        }
        return Response.ok(cart).build();
    }

    // Update an existing cart
    @PUT
    @Path("/{customerId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCart(@PathParam("customerId") int customerId, Cart updatedCart) {
        if (customerId <= 0) {
            throw new InvalidInputException("Customer ID must be a positive integer");
        }
        Cart existingCart = cartDAO.getCartByCustomerId(customerId);
        if (existingCart == null) {
            throw new CartNotFoundException("Cart for customer with ID " + customerId + " not found");
        }

        // Validate input
        if (updatedCart.getItem() == null || updatedCart.getItem().isEmpty()) {
            throw new InvalidInputException("Cart items cannot be empty");
        }
        for (Map.Entry<Integer, Integer> entry : updatedCart.getItem().entrySet()) {
            if (entry.getKey() <= 0 || entry.getValue() <= 0) {
                throw new InvalidInputException("Book ID and quantity must be positive integers");
            }
        }

        updatedCart.setCustomerId(customerId);
        cartDAO.updateCart(updatedCart);
        return Response.ok(updatedCart).build();
    }

    // Delete a cart
    @DELETE
    @Path("/{customerId}")
    public Response deleteCart(@PathParam("customerId") int customerId) {
        if (customerId <= 0) {
            throw new InvalidInputException("Customer ID must be a positive integer");
        }
        Cart cart = cartDAO.getCartByCustomerId(customerId);
        if (cart == null) {
            throw new CartNotFoundException("Cart for customer with ID " + customerId + " not found");
        }
        cartDAO.deleteCart(customerId);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}