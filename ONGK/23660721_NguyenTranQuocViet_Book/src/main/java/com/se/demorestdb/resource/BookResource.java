package com.se.demorestdb.resource;

import com.se.demorestdb.model.Book;
import com.se.demorestdb.service.BookService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/books")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {
    @Inject
    private BookService bookService;
    @GET
    public Response getAll(){
        return Response.ok(bookService.getAll()).build();
    }
    @GET
    @Path("/findByAuthor/{author}")
    public Response findByAuthor(@PathParam("author")String author){
        return Response.ok(bookService.findByAuthor(author)).build();
    }
    @POST
    public Response save(Book book){
        boolean savedBook = bookService.save(book);
        if (savedBook) {
            return Response.status(Response.Status.CREATED)
                    .build();
        }
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("Save failed")
                .build();
    }

}
