package com.westminster.bookstore.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class BookNotFoundExceptionMapper implements ExceptionMapper<BookNotFoundException> {
    @Override
    public Response toResponse(BookNotFoundException exception) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity("{\"message\": \"book id does not exist\"}")
                .type("application/json")
                .build();
    }
}