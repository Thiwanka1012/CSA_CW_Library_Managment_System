package com.westminster.bookstore.resources;

import com.westminster.bookstore.storage.AuthorDAO;
import com.westminster.bookstore.model.Author;
import com.westminster.bookstore.exceptions.AuthorNotFoundException;
import com.westminster.bookstore.exceptions.InvalidInputException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/authors")
public class AuthorResources {
    private AuthorDAO authorDAO = new AuthorDAO();

    // Create a new author
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createAuthor(Author author) {
        // Validate input
        if (author.getAuthorName() == null || author.getAuthorName().isEmpty()) {
            throw new InvalidInputException("Author name cannot be empty");
        }
        if (author.getBiography() == null || author.getBiography().isEmpty()) {
            throw new InvalidInputException("Biography cannot be empty");
        }

        authorDAO.addAuthor(author);
        return Response.status(Response.Status.CREATED).entity(author).build();
    }

    // Get all authors
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Author> getAllAuthors() {
        return authorDAO.getAllAuthors();
    }

    // Get author by ID
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAuthorById(@PathParam("id") int id) {
        Author author = authorDAO.getAuthorById(id);
        if (author == null) {
            throw new AuthorNotFoundException("Author with ID " + id + " not found");
        }
        return Response.ok(author).build();
    }

    // Update an existing author
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateAuthor(@PathParam("id") int id, Author updatedAuthor) {
        Author existingAuthor = authorDAO.getAuthorById(id);
        if (existingAuthor == null) {
            throw new AuthorNotFoundException("Author with ID " + id + " not found");
        }

        // Validate input
        if (updatedAuthor.getAuthorName() == null || updatedAuthor.getAuthorName().isEmpty()) {
            throw new InvalidInputException("Author name cannot be empty");
        }
        if (updatedAuthor.getBiography() == null || updatedAuthor.getBiography().isEmpty()) {
            throw new InvalidInputException("Biography cannot be empty");
        }

        updatedAuthor.setAuthorId(id);
        authorDAO.updateAuthor(updatedAuthor);
        return Response.ok(updatedAuthor).build();
    }

    // Delete an author
    @DELETE
    @Path("/{id}")
    public Response deleteAuthor(@PathParam("id") int id) {
        Author author = authorDAO.getAuthorById(id);
        if (author == null) {
            throw new AuthorNotFoundException("Author with ID " + id + " not found");
        }
        authorDAO.deleteAuthor(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}