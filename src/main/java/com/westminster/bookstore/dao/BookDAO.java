package com.westminster.bookstore.dao;

import com.westminster.bookstore.model.Book;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private static List<Book> books = new ArrayList<>();

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

    public void addBook(Book book) {
        books.add(book);
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