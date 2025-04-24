package com.westminster.bookstore.storage;

import com.westminster.bookstore.model.Book;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private static List<Book> books = new ArrayList<>();

    // Initialize with some sample data
    static {
        books.add(new Book("The Lord of the Rings", 1, "J.R.R. Tolkien", "9780618053267", 1954, 20.99, 100));
        books.add(new Book("Harry Potter and the Philosopher's Stone", 2, "J.K. Rowling", "9780747532699", 1997, 15.99, 50));
    }

    // Get all books
    public List<Book> getAllBooks() {
        return new ArrayList<>(books); // Return a copy to prevent direct modification
    }

    // Get book by ID
    public Book getBookById(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }

    // Add a new book
    public void addBook(Book book) {
        int newId = getNextBookId();
        book.setBookId(newId);
        books.add(book);
    }

    // Update an existing book
    public void updateBook(Book updatedBook) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookId() == updatedBook.getBookId()) {
                books.set(i, updatedBook);
                return;
            }
        }
    }

    // Delete a book by ID
    public void deleteBook(int bookId) {
        books.removeIf(book -> book.getBookId() == bookId);
    }

    // Generate the next book ID
    private int getNextBookId() {
        int maxId = 0;
        for (Book book : books) {
            if (book.getBookId() > maxId) {
                maxId = book.getBookId();
            }
        }
        return maxId + 1;
    }
}