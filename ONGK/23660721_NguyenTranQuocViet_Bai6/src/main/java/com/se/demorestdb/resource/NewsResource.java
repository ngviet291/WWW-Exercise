package com.se.demorestdb.resource;

import com.se.demorestdb.model.News;
import com.se.demorestdb.service.NewsService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/news")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class NewsResource {
    @Inject
    private NewsService newsService;
    public NewsResource(){

    }
    @GET
    public Response getAllNews(){
        List<News> news = newsService.getAllNews();
        return Response.ok(news).build();
    }
    @GET
    @Path("/{id}")
    public  Response getById(@PathParam("id") int id){
        News news= newsService.getNewsById(id);
        if(news==null ){
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(news).build();
    }
    @POST
    public Response addNews(News news){
        newsService.addNews(news);
        return Response.status(Response.Status.CREATED).build();
    }
    @PUT
    @Path("/{id}")
    public Response updateNews(@PathParam("id") int id,News news){
        news.setId(id);
        newsService.updateNews(news);
        return Response.ok().build();
    }
    @DELETE
    @Path("/{id}")
    public Response deleteNews(@PathParam("id") int id){
        newsService.deleteNews(id);
        return  Response.noContent().build();
    }
    @GET
    @Path("/with-category")
    public Response getAllNewsWithCategory() {
        List<News> newsList = newsService.getAllNewsWithCategory();
        return Response.ok(newsList).build();
    }
    @GET
    @Path("/with-category/{categoryName}")
    public Response getNewsByCategoryName(@PathParam("categoryName") String categoryName) {
        List<News> newsList = newsService.getNewsByCategoryName(categoryName);
        return Response.ok(newsList).build();
    }
}
