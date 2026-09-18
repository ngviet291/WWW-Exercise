package com.ngviet291.nguyentranquocviet_23660721_bai2.resource;

import com.ngviet291.nguyentranquocviet_23660721_bai2.model.GradeReport;
import com.ngviet291.nguyentranquocviet_23660721_bai2.service.GradeService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
@Path("/grade")

public class GradeResource {
    @Inject
    private GradeService gradeService;
    @GET
    @Path("/getAll")
    public List<GradeReport> getAll(){
        return gradeService.getAll();
    }
    @GET
    @Path("/getReport/{id}")
    public GradeReport getById(@PathParam("id") String id){
        return gradeService.getReportById(id);
    }
    @POST
    @Path("/add")
    public boolean addGradeReport(GradeReport gradeReport){
        return gradeService.addReport(gradeReport);
    }
}
