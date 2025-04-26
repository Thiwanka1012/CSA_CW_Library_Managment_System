package com.westminster.bookstore.dao;

import com.westminster.bookstore.model.Author;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AuthorDAO {
    private static Map<Integer, Author> authors = new HashMap<>();
    private static int authorIdCounter = 0; // Counter for auto-generating authorId

    public List<Author> getAllAuthors() {
        return new ArrayList<>(authors.values());
    }

    public Author getAuthorById(int id) {
        return authors.get(id);
    }

    public void addAuthor(Author author) {
        // Auto-generate authorId if not provided
        if (author.getAuthorId() == 0) {
            authorIdCounter++;
            author.setAuthorId(authorIdCounter);
        } else {
            // If authorId is provided, ensure it doesn't conflict
            if (authors.containsKey(author.getAuthorId())) {
                throw new IllegalArgumentException("Author with ID " + author.getAuthorId() + " already exists.");
            }
            // Update counter if the provided ID is greater
            if (author.getAuthorId() > authorIdCounter) {
                authorIdCounter = author.getAuthorId();
            }
        }
        authors.put(author.getAuthorId(), author);
    }

    public void updateAuthor(Author updatedAuthor) {
        if (!authors.containsKey(updatedAuthor.getAuthorId())) {
            throw new IllegalArgumentException("Author with ID " + updatedAuthor.getAuthorId() + " does not exist.");
        }
        authors.put(updatedAuthor.getAuthorId(), updatedAuthor);
    }

    public void deleteAuthor(int id) {
        if (!authors.containsKey(id)) {
            throw new IllegalArgumentException("Author with ID " + id + " does not exist.");
        }
        authors.remove(id);
    }
}