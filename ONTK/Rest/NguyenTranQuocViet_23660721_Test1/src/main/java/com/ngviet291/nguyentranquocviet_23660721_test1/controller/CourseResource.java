package com.ngviet291.nguyentranquocviet_23660721_test1.controller;

import com.ngviet291.nguyentranquocviet_23660721_test1.model.Course;
import com.ngviet291.nguyentranquocviet_23660721_test1.service.CourseService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.io.Serializable;
import java.util.List;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
@Path("/course")
public class CourseResource {
    @Inject
    private CourseService courseService;
    @POST
    @Path("/add")
    public boolean addCourse(Course course){
        return courseService.addCourse(course);
    }
    @DELETE
    @Path("/delete")
    public boolean removeCourse(Course course){
        return courseService.removeCourse(course.getCourseId());
    }
    @GET
    @Path("/getAll")
    public List<Course> getAll(){
        return courseService.getCourses();
    }
    @PUT
    @Path("/edit")
    public Course editCourse(Course course){
        return courseService.editCourse(course);
    }
}

