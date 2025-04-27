package com.westminster.bookstore.exceptions;

public class AuthorNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public AuthorNotFoundException() {
        super("author id does not exist");
    }

    public AuthorNotFoundException(String message) {
        super(message);
    }
}