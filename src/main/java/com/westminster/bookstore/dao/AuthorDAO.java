package com.westminster.bookstore.dao;

import com.westminster.bookstore.model.Author;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthorDAO {
    private static Map<Integer, Author> authors = new HashMap<>();
    private static int authorIdCounter = 0;

    public List<Author> getAllAuthors() {
        return new ArrayList<>(authors.values());
    }

    public Author getAuthorById(int id) {
        return authors.get(id);
    }

    public void addAuthor(Author author) {
        if (author.getAuthorId() == 0) {
            authorIdCounter++;
            author.setAuthorId(authorIdCounter);
        } else {
            if (authors.containsKey(author.getAuthorId())) {
                throw new IllegalArgumentException("Author with ID " + author.getAuthorId() + " already exists.");
            }
            if (author.getAuthorId() > authorIdCounter) {
                authorIdCounter = author.getAuthorId();
            }
        }
        authors.put(author.getAuthorId(), author);
    }

    public void updateAuthor(Author updatedAuthor) {
        authors.put(updatedAuthor.getAuthorId(), updatedAuthor);
    }

    public void deleteAuthor(int id) {
        authors.remove(id);
    }
}