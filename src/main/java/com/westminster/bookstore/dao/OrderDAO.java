package com.westminster.bookstore.dao;

import com.westminster.bookstore.model.Order;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDAO {
    private static List<Order> orders = new ArrayList<>();

    // Initialize with some sample data
    static {
        Map<Integer, Integer> items1 = new HashMap<>();
        items1.put(1, 2); // Book ID 1, Quantity 2
        items1.put(2, 1); // Book ID 2, Quantity 1
        orders.add(new Order(1, 1, items1, 56.97, LocalDateTime.of(2025, 4, 15, 10, 30)));

        Map<Integer, Integer> items2 = new HashMap<>();
        items2.put(2, 3); // Book ID 2, Quantity 3
        orders.add(new Order(2, 2, items2, 47.97, LocalDateTime.of(2025, 4, 16, 14, 45)));
    }

    // Get all orders
    public List<Order> getAllOrders() {
        return new ArrayList<>(orders); // Return a copy to prevent direct modification
    }

    // Get order by ID
    public Order getOrderById(int orderId) {
        for (Order order : orders) {
            if (order.getOrderId() == orderId) {
                return order;
            }
        }
        return null;
    }

    // Add a new order
    public void addOrder(Order order) {
        int newId = getNextOrderId();
        order.setOrderId(newId);
        orders.add(order);
    }

    // Update an existing order
    public void updateOrder(Order updatedOrder) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderId() == updatedOrder.getOrderId()) {
                orders.set(i, updatedOrder);
                return;
            }
        }
    }

    // Delete an order by ID
    public void deleteOrder(int orderId) {
        orders.removeIf(order -> order.getOrderId() == orderId);
    }

    // Generate the next order ID
    private int getNextOrderId() {
        int maxId = 0;
        for (Order order : orders) {
            if (order.getOrderId() > maxId) {
                maxId = order.getOrderId();
            }
        }
        return maxId + 1;
    }
}
