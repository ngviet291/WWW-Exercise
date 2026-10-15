package com.se.demorestdb.resource;

import com.se.demorestdb.model.Publisher;
import com.se.demorestdb.service.PublisherService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
@Path("/publishers")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PublisherResource {
    @Inject
    private PublisherService publisherService;
    @GET
    public Response getPublishers(){
        return Response.ok(publisherService.getPublishers()).build();
    }
    @GET
    @Path("/{id}")
    public Response getPublisher(@PathParam("id") int id){
        return Response.ok(publisherService.getPublisher(id)).build();
    }
    @GET
    @Path("/{publisherId}/books/search")
    public Response findByPublisherAndAuthor(@PathParam("publisherId") int publisherId, @QueryParam("authorKeyword") String authorKeyword){
        Publisher publisher= publisherService.getPublisher(publisherId);
        if(publisher==null){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(publisherService.findByPublisherAndAuthor(publisherId,authorKeyword)).build();
    }
    @GET
    @Path("/static")
    public Response getStatistics(){
        return Response.ok(publisherService.getStatistics()).build();
    }
    @GET
    @Path("/count")
    public Response countBooksByPublisher(){
        return Response.ok(publisherService.countBooksByPublisher()).build();
    }
}
