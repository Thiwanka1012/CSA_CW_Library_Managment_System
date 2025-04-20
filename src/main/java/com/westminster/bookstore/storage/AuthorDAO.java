package com.westminster.bookstore.storage;

import com.westminster.bookstore.model.Author;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAO {
    private static List<Author> authors = new ArrayList<>();

    // Initialize with some sample data
    static {
        authors.add(new Author(1, "J.R.R. Tolkien", "John Ronald Reuel Tolkien was an English writer, poet, philologist, and academic, best known for The Lord of the Rings."));
        authors.add(new Author(2, "J.K. Rowling", "Joanne Rowling, known by her pen name J.K. Rowling, is a British author, best known for the Harry Potter series."));
    }

    // Get all authors
    public List<Author> getAllAuthors() {
        return new ArrayList<>(authors); // Return a copy to prevent direct modification
    }

    // Get author by ID
    public Author getAuthorById(int authorId) {
        for (Author author : authors) {
            if (author.getAuthorId() == authorId) {
                return author;
            }
        }
        return null;
    }

    // Add a new author
    public void addAuthor(Author author) {
        int newId = getNextAuthorId();
        author.setAuthorId(newId);
        authors.add(author);
    }

    // Update an existing author
    public void updateAuthor(Author updatedAuthor) {
        for (int i = 0; i < authors.size(); i++) {
            if (authors.get(i).getAuthorId() == updatedAuthor.getAuthorId()) {
                authors.set(i, updatedAuthor);
                return;
            }
        }
    }

    // Delete an author by ID
    public void deleteAuthor(int authorId) {
        authors.removeIf(author -> author.getAuthorId() == authorId);
    }

    // Generate the next author ID
    private int getNextAuthorId() {
        int maxId = 0;
        for (Author author : authors) {
            if (author.getAuthorId() > maxId) {
                maxId = author.getAuthorId();
            }
        }
        return maxId + 1;
    }
}
