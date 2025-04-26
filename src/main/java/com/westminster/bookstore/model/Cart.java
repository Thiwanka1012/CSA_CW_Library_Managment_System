package com.westminster.bookstore.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private int customerId;
    private List<CartItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public Cart(int customerId, List<CartItem> items) {
        this.customerId = customerId;
        this.items = items != null ? items : new ArrayList<>();
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items != null ? items : new ArrayList<>();
    }

    public double getTotalPrice() {
        // This method assumes you have access to book prices via a BookDAO
        // For now, we'll return 0.0 as a placeholder
        return 0.0;
    }

    @Override
    public String toString() {
        return "Cart{" + "customerId=" + customerId + ", items=" + items + '}';
    }
}