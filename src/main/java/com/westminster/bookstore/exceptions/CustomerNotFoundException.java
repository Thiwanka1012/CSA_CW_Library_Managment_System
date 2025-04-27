package com.westminster.bookstore.exceptions;

public class CustomerNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CustomerNotFoundException() {
        super("customer id does not exist");
    }

    public CustomerNotFoundException(String message) {
        super(message);
    }
}