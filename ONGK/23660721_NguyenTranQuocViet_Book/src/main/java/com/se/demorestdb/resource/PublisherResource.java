package com.se.demorestdb.resource;

import com.se.demorestdb.dto.PublisherQuantityDto;
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
    @GET
    @Path("/at-least/{n}")
    public Response findWithAtLeast(@PathParam("n") int n){
        List<PublisherQuantityDto> publisherQuantityDtos = publisherService.findWithAtLeast(n);
        return Response.ok(publisherQuantityDtos).build();
    }
    @GET
    @Path("/avgPriceByPublisher")
    public Response avgPriceByPublisher(){
        return Response.ok(publisherService.avgPriceByPublisher()).build();
    }
    @GET
    @Path("/totalPriceByPublisher")
    public Response sumPriceByPublisher(){
        return Response.ok(publisherService.sumPriceByPublisher()).build();
    }
    @GET
    @Path("/findWithTotalAbove/{x}")
    public Response findWithTotalAbove(@PathParam("x") double x){
        return Response.ok(publisherService.findWithTotalAbove(x)).build();
    }
    @GET
    @Path("/findWithAtLeastSortedDesc/{n}")
    public Response findWithAtLeastSortedDesc(@PathParam("n") int n){
        return  Response.ok(publisherService.findWithAtLeastSortedDesc(n)).build();
    }
    @GET
    @Path("/findWithoutBooks")
    public Response findWithoutBooks(){
        return Response.ok(publisherService.findWithoutBooks()).build();
    }
}
