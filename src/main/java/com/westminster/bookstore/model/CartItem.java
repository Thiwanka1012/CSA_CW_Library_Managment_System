package com.westminster.bookstore.model;

public class CartItem {
    private int bookId;
    private int quantity;

    public CartItem() {
    }

    public CartItem(int bookId, int quantity) {
        this.bookId = bookId;
        this.quantity = quantity;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" + "bookId=" + bookId + ", quantity=" + quantity + '}';
    }
}