package com.westminster.bookstore.resources;

import com.westminster.bookstore.storage.BookDAO;
import com.westminster.bookstore.model.Book;
import com.westminster.bookstore.exceptions.BookNotFoundException;
import com.westminster.bookstore.exceptions.InvalidInputException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/books")
public class BookResources {
    private BookDAO bookDAO = new BookDAO();

    // Create a new book
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createBook(Book book) {
        // Validate input
        if (book.getTitle() == null || book.getTitle().isEmpty()) {
            throw new InvalidInputException("Book title cannot be empty");
        }
        if (book.getAuthorName() == null || book.getAuthorName().isEmpty()) {
            throw new InvalidInputException("Author name cannot be empty");
        }
        if (book.getIsbn() == null || book.getIsbn().isEmpty()) {
            throw new InvalidInputException("ISBN cannot be empty");
        }
        if (book.getPublicationYear() > 2025) {
            throw new InvalidInputException("Publication year cannot be in the future");
        }
        if (book.getPrice() <= 0) {
            throw new InvalidInputException("Price must be greater than zero");
        }
        if (book.getStockQuantity() < 0) {
            throw new InvalidInputException("Stock quantity cannot be negative");
        }

        bookDAO.addBook(book);
        return Response.status(Response.Status.CREATED).entity(book).build();
    }

    // Get all books
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getAllBooks() {
        return bookDAO.getAllBooks();
    }

    // Get book by ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBookById(@PathParam("id") int id) {
        Book book = bookDAO.getBookById(id);
        if (book == null) {
            throw new BookNotFoundException("Book with ID " + id + " not found");
        }
        return Response.ok(book).build();
    }

    // Update a book
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateBook(@PathParam("id") int id, Book updatedBook) {
        Book existingBook = bookDAO.getBookById(id);
        if (existingBook == null) {
            throw new BookNotFoundException("Book with ID " + id + " not found");
        }

        // Validate input
        if (updatedBook.getTitle() == null || updatedBook.getTitle().isEmpty()) {
            throw new InvalidInputException("Book title cannot be empty");
        }
        if (updatedBook.getAuthorName() == null || updatedBook.getAuthorName().isEmpty()) {
            throw new InvalidInputException("Author name cannot be empty");
        }
        if (updatedBook.getIsbn() == null || updatedBook.getIsbn().isEmpty()) {
            throw new InvalidInputException("ISBN cannot be empty");
        }
        if (updatedBook.getPublicationYear() > 2025) {
            throw new InvalidInputException("Publication year cannot be in the future");
        }
        if (updatedBook.getPrice() <= 0) {
            throw new InvalidInputException("Price must be greater than zero");
        }
        if (updatedBook.getStockQuantity() < 0) {
            throw new InvalidInputException("Stock quantity cannot be negative");
        }

        updatedBook.setBookId(id);
        bookDAO.updateBook(updatedBook);
        return Response.ok(updatedBook).build();
    }

    // Delete a book
    @DELETE
    @Path("/{id}")
    public Response deleteBook(@PathParam("id") int id) {
        Book book = bookDAO.getBookById(id);
        if (book == null) {
            throw new BookNotFoundException("Book with ID " + id + " not found");
        }
        bookDAO.deleteBook(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}