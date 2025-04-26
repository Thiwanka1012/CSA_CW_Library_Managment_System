package com.westminster.bookstore.dao;

import com.westminster.bookstore.model.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookDAO {
    private static Map<Integer, Book> books = new HashMap<>();
    private static int bookIdCounter = 0; // Counter for auto-generating bookId
    private AuthorDAO authorDAO = new AuthorDAO(); // Inject AuthorDAO to validate authorId

    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    public List<Book> getBooksByAuthorId(int authorId) {
        List<Book> authorBooks = new ArrayList<>();
        for (Book book : books.values()) {
            if (book.getAuthorId() == authorId) {
                authorBooks.add(book);
            }
        }
        return authorBooks;
    }

    public Book getBookById(int id) {
        return books.get(id);
    }

    public void addBook(Book book) {
        // Validate authorId exists in AuthorDAO
        if (authorDAO.getAuthorById(book.getAuthorId()) == null) {
            throw new IllegalArgumentException("Author with ID " + book.getAuthorId() + " does not exist.");
        }

        // Auto-generate bookId if not provided
        if (book.getBookId() == 0) {
            bookIdCounter++;
            book.setBookId(bookIdCounter);
        } else {
            // If bookId is provided, ensure it doesn't conflict
            if (books.containsKey(book.getBookId())) {
                throw new IllegalArgumentException("Book with ID " + book.getBookId() + " already exists.");
            }
            // Update counter if the provided ID is greater
            if (book.getBookId() > bookIdCounter) {
                bookIdCounter = book.getBookId();
            }
        }
        books.put(book.getBookId(), book);
    }

    public void updateBook(Book updatedBook) {
        if (!books.containsKey(updatedBook.getBookId())) {
            throw new IllegalArgumentException("Book with ID " + updatedBook.getBookId() + " does not exist.");
        }
        // Validate authorId exists in AuthorDAO
        if (authorDAO.getAuthorById(updatedBook.getAuthorId()) == null) {
            throw new IllegalArgumentException("Author with ID " + updatedBook.getAuthorId() + " does not exist.");
        }
        books.put(updatedBook.getBookId(), updatedBook);
    }

    public void deleteBook(int id) {
        if (!books.containsKey(id)) {
            throw new IllegalArgumentException("Book with ID " + id + " does not exist.");
        }
        books.remove(id);
    }
}