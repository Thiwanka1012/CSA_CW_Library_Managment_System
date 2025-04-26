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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCustomer(Customer customer) {
        if (customer.getFirstName() == null || customer.getFirstName().isEmpty()) {
            throw new InvalidInputException("First name cannot be empty");
        }
        if (customer.getLastName() == null || customer.getLastName().isEmpty()) {
            throw new InvalidInputException("Last name cannot be empty");
        }
        if (customer.getEmailAddress() == null || customer.getEmailAddress().isEmpty()) {
            throw new InvalidInputException("Email address cannot be empty");
        }
        if (customer.getPassword() == null || customer.getPassword().isEmpty()) {
            throw new InvalidInputException("Password cannot be empty");
        }
        try {
            customerDAO.addCustomer(customer);
            return Response.status(Response.Status.CREATED).entity(customer).build();
        } catch (IllegalArgumentException e) {
            throw new InvalidInputException(e.getMessage());
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getAllCustomers() {
        return customerDAO.getAllCustomers();
    }

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

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCustomer(@PathParam("id") int id, Customer updatedCustomer) {
        Customer existingCustomer = customerDAO.getCustomerById(id);
        if (existingCustomer == null) {
            throw new CustomerNotFoundException("Customer with ID " + id + " not found");
        }
        if (updatedCustomer.getFirstName() == null || updatedCustomer.getFirstName().isEmpty()) {
            throw new InvalidInputException("First name cannot be empty");
        }
        if (updatedCustomer.getLastName() == null || updatedCustomer.getLastName().isEmpty()) {
            throw new InvalidInputException("Last name cannot be empty");
        }
        if (updatedCustomer.getEmailAddress() == null || updatedCustomer.getEmailAddress().isEmpty()) {
            throw new InvalidInputException("Email address cannot be empty");
        }
        if (updatedCustomer.getPassword() == null || updatedCustomer.getPassword().isEmpty()) {
            throw new InvalidInputException("Password cannot be empty");
        }
        updatedCustomer.setCustomerId(id);
        try {
            customerDAO.updateCustomer(updatedCustomer);
            return Response.ok(updatedCustomer).build();
        } catch (IllegalArgumentException e) {
            throw new InvalidInputException(e.getMessage());
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCustomer(@PathParam("id") int id) {
        Customer customer = customerDAO.getCustomerById(id);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer with ID " + id + " not found");
        }
        try {
            customerDAO.deleteCustomer(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        } catch (IllegalArgumentException e) {
            throw new InvalidInputException(e.getMessage());
        }
    }
}