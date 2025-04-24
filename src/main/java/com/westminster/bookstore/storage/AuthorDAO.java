package com.westminster.bookstore.storage;

import com.westminster.bookstore.model.Author;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAO {
    private static List<Author> authors = new ArrayList<>();

    static {
        authors.add(new Author(1, "George", "Orwell", "Author of 1984 and Animal Farm"));
        authors.add(new Author(2, "J.K.", "Rowling", "Author of Harry Potter series"));
    }

    public List<Author> getAllAuthors() {
        return new ArrayList<>(authors);
    }

    public Author getAuthorById(int id) {
        for (Author author : authors) {
            if (author.getAuthorId() == id) {
                return author;
            }
        }
        return null;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void updateAuthor(Author updatedAuthor) {
        for (int i = 0; i < authors.size(); i++) {
            if (authors.get(i).getAuthorId() == updatedAuthor.getAuthorId()) {
                authors.set(i, updatedAuthor);
                return;
            }
        }
    }

    public void deleteAuthor(int id) {
        authors.removeIf(author -> author.getAuthorId() == id);
    }
}