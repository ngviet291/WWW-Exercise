package com.ngviet291.nguyentranquocviet_23660721_test1.service;

import com.ngviet291.nguyentranquocviet_23660721_test1.model.Course;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Setter
@Getter
public class CourseService implements Serializable {
    private final List<Course> courses = new ArrayList<>(List.of(
            new Course("101","120","sadihsad")
    ));
    public boolean addCourse(Course course){
        return courses.add(course);
    }
    public boolean removeCourse(String id){
        return courses.removeIf(course -> course.getCourseId().equals(id));
    }
    public List<Course> getCourses(){
        return courses;
    }
    public Course editCourse(Course course){
        for(Course c: courses){
            if(c.getCourseId().equals(course.getCourseId())){
                c.setCourseName(course.getCourseName());
                c.setInstructor(course.getInstructor());
            }
        }
        return course;
    }
}
