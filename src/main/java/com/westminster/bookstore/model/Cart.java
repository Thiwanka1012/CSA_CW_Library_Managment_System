package com.westminster.bookstore.model;

import com.westminster.bookstore.dao.BookDAO;

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
        BookDAO bookDAO = new BookDAO();
        double total = 0.0;
        for (CartItem item : items) {
            Book book = bookDAO.getBookById(item.getBookId());
            if (book != null) {
                total += book.getPrice() * item.getQuantity();
            }
        }
        return total;
    }

    @Override
    public String toString() {
        return "Cart{" + "customerId=" + customerId + ", items=" + items + ", totalPrice=" + getTotalPrice() + '}';
    }
}