/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.westminster.bookstore.model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Thiwanka-Gaming
 */
public class Order {
    
    //Attributes
    private int orderId;
    private int customerId;
    private Map<Integer,Integer> items;
    private double totalPrice;
    private LocalDateTime orderDate;

    //Non parameterized Constructor
    public Order() {
    }

    //Parameterized constructor
    public Order(int orderId, int customerId, Map<Integer, Integer> items, double totalPrice, LocalDateTime orderDate) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.items = items;
        this.totalPrice = totalPrice;
        this.orderDate = orderDate;
    }

    
    //Getter methods
    public int getOrderId() {
        return orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Map<Integer, Integer> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    
    //Setter methods
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setItems(Map<Integer, Integer> items) {
        this.items = items;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    
    //To string method
    @Override
    public String toString() {
        return "Order{" + "orderId=" + orderId + ", customerId=" + customerId + ", items=" + items + ", totalPrice=" + totalPrice + ", orderDate=" + orderDate + '}';
    }
    
    
    
    
    
    
    
    
    
}
