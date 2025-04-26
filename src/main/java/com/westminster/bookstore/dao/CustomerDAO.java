package com.westminster.bookstore.dao;

import com.westminster.bookstore.model.Customer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerDAO {
    private static Map<Integer, Customer> customers = new HashMap<>();
    private static int customerIdCounter = 0; // Counter for auto-generating customerId

    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customers.values());
    }

    public Customer getCustomerById(int id) {
        return customers.get(id);
    }

    public void addCustomer(Customer customer) {
        // Auto-generate customerId if not provided
        if (customer.getCustomerId() == 0) {
            customerIdCounter++;
            customer.setCustomerId(customerIdCounter);
        } else {
            // If customerId is provided, ensure it doesn't conflict
            if (customers.containsKey(customer.getCustomerId())) {
                throw new IllegalArgumentException("Customer with ID " + customer.getCustomerId() + " already exists.");
            }
            // Update counter if the provided ID is greater
            if (customer.getCustomerId() > customerIdCounter) {
                customerIdCounter = customer.getCustomerId();
            }
        }
        customers.put(customer.getCustomerId(), customer);
    }

    public void updateCustomer(Customer updatedCustomer) {
        if (!customers.containsKey(updatedCustomer.getCustomerId())) {
            throw new IllegalArgumentException("Customer with ID " + updatedCustomer.getCustomerId() + " does not exist.");
        }
        customers.put(updatedCustomer.getCustomerId(), updatedCustomer);
    }

    public void deleteCustomer(int id) {
        if (!customers.containsKey(id)) {
            throw new IllegalArgumentException("Customer with ID " + id + " does not exist.");
        }
        customers.remove(id);
    }
}