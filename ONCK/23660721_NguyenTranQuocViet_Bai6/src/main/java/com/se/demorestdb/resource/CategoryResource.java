package com.se.demorestdb.resource;

import com.se.demorestdb.model.Category;
import com.se.demorestdb.service.CategoryService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/categories")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryResource {
    @Inject
    private CategoryService categoryService;
    @GET
    public Response getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return Response.ok(categories).build();
    }
    @GET
    @Path("/{id}")
    public Response getCategoryById(@PathParam("id") int id) {
        Category category = categoryService.getCategoryById(id);
        if (category == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(category).build();
    }
    @POST
    public Response addCategory(Category category) {
        categoryService.addCategory(category);
        return Response.status(Response.Status.CREATED).build();
    }
    @PUT
    @Path("/{id}")
    public Response updateCategory(@PathParam("id") int id, Category category) {
        category.setId(id);
        categoryService.updateCategory(category);
        return Response.ok().build();
    }
    @DELETE
    @Path("/{id}")
    public Response deleteCategory(@PathParam("id") int id) {
        categoryService.deleteCategory(id);
        return Response.noContent().build();
    }
}
