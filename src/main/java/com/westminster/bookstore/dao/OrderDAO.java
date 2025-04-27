package com.westminster.bookstore.dao;

import com.westminster.bookstore.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderDAO {
    private static List<Order> orders = new ArrayList<>();
    private static int nextId = 1;

    public Order addOrder(Order order) {
        order.setOrderId(nextId++);
        orders.add(order);
        return order;
    }

    public List<Order> getOrdersByCustomerId(int customerId) {
        List<Order> customerOrders = new ArrayList<>();
        for (Order order : orders) {
            if (order.getCustomerId() == customerId) {
                customerOrders.add(order);
            }
        }
        return customerOrders;
    }

    public Order getOrderById(int orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                return order;
            }
        }
        return null;
    }

    public void clearOrders() {
        orders.clear();
        nextId = 1;
    }
}