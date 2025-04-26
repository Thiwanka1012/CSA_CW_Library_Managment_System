package com.westminster.bookstore.dao;

import com.westminster.bookstore.model.Customer;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private static List<Customer> customers = new ArrayList<>();



    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customers);
    }

    public Customer getCustomerById(int id) {
        for (Customer customer : customers) {
            if (customer.getCustomerId() == id) {
                return customer;
            }
        }
        return null;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void updateCustomer(Customer updatedCustomer) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCustomerId() == updatedCustomer.getCustomerId()) {
                customers.set(i, updatedCustomer);
                return;
            }
        }
    }

    public void deleteCustomer(int id) {
        customers.removeIf(customer -> customer.getCustomerId() == id);
    }
}