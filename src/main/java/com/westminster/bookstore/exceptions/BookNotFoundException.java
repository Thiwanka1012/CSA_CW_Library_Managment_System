package com.westminster.bookstore.exceptions;

public class BookNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BookNotFoundException() {
        super("book id does not exist");
    }

    public BookNotFoundException(String message) {
        super(message);
    }
}