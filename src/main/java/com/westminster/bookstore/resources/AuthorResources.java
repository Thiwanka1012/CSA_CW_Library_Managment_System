package com.westminster.bookstore.resources;

import com.westminster.bookstore.dao.AuthorDAO;
import com.westminster.bookstore.dao.BookDAO;
import com.westminster.bookstore.model.Author;
import com.westminster.bookstore.model.Book;
import com.westminster.bookstore.exceptions.AuthorNotFoundException;
import com.westminster.bookstore.exceptions.InvalidInputException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/authors")
public class AuthorResources {
    private AuthorDAO authorDAO = new AuthorDAO();
    private BookDAO bookDAO = new BookDAO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createAuthor(Author author) {
        if (author.getFirstName() == null || author.getFirstName().isEmpty()) {
            throw new InvalidInputException("First name cannot be empty");
        }
        if (author.getLastName() == null || author.getLastName().isEmpty()) {
            throw new InvalidInputException("Last name cannot be empty");
        }
        if (author.getBiography() == null || author.getBiography().isEmpty()) {
            throw new InvalidInputException("Biography cannot be empty");
        }
        authorDAO.addAuthor(author);
        return Response.status(Response.Status.CREATED).entity(author).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Author> getAllAuthors() {
        return authorDAO.getAllAuthors();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAuthorById(@PathParam("id") int id) {
        Author author = authorDAO.getAuthorById(id);
        if (author == null) {
            throw new AuthorNotFoundException("author id does not exist");
        }
        return Response.ok(author).build();
    }

    @GET
    @Path("/{id}/books")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBooksByAuthorId(@PathParam("id") int id) {
        Author author = authorDAO.getAuthorById(id);
        if (author == null) {
            throw new AuthorNotFoundException("author id does not exist");
        }
        List<Book> books = bookDAO.getBooksByAuthorId(id);
        return Response.ok(books).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateAuthor(@PathParam("id") int id, Author updatedAuthor) {
        Author existingAuthor = authorDAO.getAuthorById(id);
        if (existingAuthor == null) {
            throw new AuthorNotFoundException("author id does not exist");
        }
        if (updatedAuthor.getFirstName() == null || updatedAuthor.getFirstName().isEmpty()) {
            throw new InvalidInputException("First name cannot be empty");
        }
        if (updatedAuthor.getLastName() == null || updatedAuthor.getLastName().isEmpty()) {
            throw new InvalidInputException("Last name cannot be empty");
        }
        if (updatedAuthor.getBiography() == null || updatedAuthor.getBiography().isEmpty()) {
            throw new InvalidInputException("Biography cannot be empty");
        }
        updatedAuthor.setAuthorId(id);
        authorDAO.updateAuthor(updatedAuthor);
        return Response.ok(updatedAuthor).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteAuthor(@PathParam("id") int id) {
        Author author = authorDAO.getAuthorById(id);
        if (author == null) {
            throw new AuthorNotFoundException("author id does not exist");
        }
        authorDAO.deleteAuthor(id);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}