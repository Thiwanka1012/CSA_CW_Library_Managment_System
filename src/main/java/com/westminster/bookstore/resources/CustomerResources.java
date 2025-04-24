package com.westminster.bookstore.resources;

import com.westminster.bookstore.dao.CustomerDAO;
import com.westminster.bookstore.model.Customer;
import com.westminster.bookstore.exceptions.CustomerNotFoundException;
import com.westminster.bookstore.exceptions.InvalidInputException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/customers")
public class CustomerResources {
    private CustomerDAO customerDAO = new CustomerDAO();

    // Create a new customer
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCustomer(Customer customer) {
        // Validate input
        if (customer.getCustomerName() == null || customer.getCustomerName().isEmpty()) {
            throw new InvalidInputException("Customer name cannot be empty");
        }
        if (customer.getEmailAddress() == null || customer.getEmailAddress().isEmpty()) {
            throw new InvalidInputException("Email address cannot be empty");
        }
        if (!isValidEmail(customer.getEmailAddress())) {
            throw new InvalidInputException("Invalid email address format");
        }
        if (customer.getPassword() <= 0) {
            throw new InvalidInputException("Password must be a positive integer");
        }

        customerDAO.addCustomer(customer);
        return Response.status(Response.Status.CREATED).entity(customer).build();
    }

    // Get all customers
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

    // Get customer by ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomerById(@PathParam("id") int id) {
        Customer customer = customerDAO.getCustomerById(id);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer with ID " + id + " not found");
        }
        return Response.ok(customer).build();
    }

    // Update an existing customer
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCustomer(@PathParam("id") int id, Customer updatedCustomer) {
        Customer existingCustomer = customerDAO.getCustomerById(id);
        if (existingCustomer == null) {
            throw new CustomerNotFoundException("Customer with ID " + id + " not found");
        }

        // Validate input
        if (updatedCustomer.getCustomerName() == null || updatedCustomer.getCustomerName().isEmpty()) {
            throw new InvalidInputException("Customer name cannot be empty");
        }
        if (updatedCustomer.getEmailAddress() == null || updatedCustomer.getEmailAddress().isEmpty()) {
            throw new InvalidInputException("Email address cannot be empty");
        }
        if (!isValidEmail(updatedCustomer.getEmailAddress())) {
            throw new InvalidInputException("Invalid email address format");
        }
        if (updatedCustomer.getPassword() <= 0) {
            throw new InvalidInputException("Password must be a positive integer");
        }

        updatedCustomer.setCustomerId(id);
        customerDAO.updateCustomer(updatedCustomer);
        return Response.ok(updatedCustomer).build();
    }

    // Delete a customer
    @DELETE
    @Path("/{id}")
    public Response deleteCustomer(@PathParam("id") int id) {
        Customer customer = customerDAO.getCustomerById(id);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer with ID " + id + " not found");
        }
        customerDAO.deleteCustomer(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    // Helper method to validate email format
    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(emailRegex);
    }
}