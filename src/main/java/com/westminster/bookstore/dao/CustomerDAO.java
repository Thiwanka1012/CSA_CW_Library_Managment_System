package com.westminster.bookstore.dao;

import com.westminster.bookstore.model.Customer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerDAO {
    private static Map<Integer, Customer> customers = new HashMap<>();
    private static int customerIdCounter = 0;

    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customers.values());
    }

    public Customer getCustomerById(int id) {
        return customers.get(id);
    }

    public void addCustomer(Customer customer) {
        if (customer.getCustomerId() == 0) {
            customerIdCounter++;
            customer.setCustomerId(customerIdCounter);
        } else {
            if (customers.containsKey(customer.getCustomerId())) {
                throw new IllegalArgumentException("Customer with ID " + customer.getCustomerId() + " already exists.");
            }
            if (customer.getCustomerId() > customerIdCounter) {
                customerIdCounter = customer.getCustomerId();
            }
        }
        customers.put(customer.getCustomerId(), customer);
    }

    public void updateCustomer(Customer updatedCustomer) {
        customers.put(updatedCustomer.getCustomerId(), updatedCustomer);
    }

    public void deleteCustomer(int id) {
        customers.remove(id);
    }
}