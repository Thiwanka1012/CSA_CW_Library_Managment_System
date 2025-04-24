package com.westminster.bookstore.exceptions;

public class OutOfStockException extends RuntimeException {
    public OutOfStockException(String message) {
        super(message);
    }
}