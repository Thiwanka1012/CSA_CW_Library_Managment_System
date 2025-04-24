package com.westminster.bookstore.storage;

import com.westminster.bookstore.model.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private static List<Customer> customers = new ArrayList<>();

    // Initialize with some sample data
    static {
        customers.add(new Customer(1, "John Doe", "john.doe@example.com", 123456));
        customers.add(new Customer(2, "Jane Smith", "jane.smith@example.com", 789012));
    }

    // Get all customers
    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customers); // Return a copy to prevent direct modification
    }

    // Get customer by ID
    public Customer getCustomerById(int customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId() == customerId) {
                return customer;
            }
        }
        return null;
    }

    // Add a new customer
    public void addCustomer(Customer customer) {
        int newId = getNextCustomerId();
        customer.setCustomerId(newId);
        customers.add(customer);
    }

    // Update an existing customer
    public void updateCustomer(Customer updatedCustomer) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCustomerId() == updatedCustomer.getCustomerId()) {
                customers.set(i, updatedCustomer);
                return;
            }
        }
    }

    // Delete a customer by ID
    public void deleteCustomer(int customerId) {
        customers.removeIf(customer -> customer.getCustomerId() == customerId);
    }

    // Generate the next customer ID
    private int getNextCustomerId() {
        int maxId = 0;
        for (Customer customer : customers) {
            if (customer.getCustomerId() > maxId) {
                maxId = customer.getCustomerId();
            }
        }
        return maxId + 1;
    }
}