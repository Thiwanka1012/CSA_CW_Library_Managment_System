package com.westminster.bookstore.dao;

import com.westminster.bookstore.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private static List<Book> books = new ArrayList<>();
    private static int nextId = 1;

    public Book addBook(Book book) {
        book.setBookId(nextId++);
        books.add(book);
        return book;
    }

    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    public Book getBookById(int id) {
        for (Book book : books) {
            if (book.getBookId() == id) {
                return book;
            }
        }
        return null;
    }

    public List<Book> getBooksByAuthorId(int authorId) {
        List<Book> booksByAuthor = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthorId() == authorId) {
                booksByAuthor.add(book);
            }
        }
        return booksByAuthor;
    }

    public void updateBook(Book updatedBook) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookId() == updatedBook.getBookId()) {
                books.set(i, updatedBook);
                return;
            }
        }
    }

    public void deleteBook(int id) {
        books.removeIf(book -> book.getBookId() == id);
    }
}