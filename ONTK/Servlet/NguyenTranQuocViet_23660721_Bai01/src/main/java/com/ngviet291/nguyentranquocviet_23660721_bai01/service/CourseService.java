package com.ngviet291.nguyentranquocviet_23660721_bai01.service;

import com.ngviet291.nguyentranquocviet_23660721_bai01.model.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class CourseService {

    private static final List<Course> courses = new ArrayList<>(List.of(
            new Course(1, "Lập trình Java cơ bản", "Nguyễn Văn A", "a@abc.com",
                    "Lập trình", "Cơ bản", 1500000, 40, "2026-10-01", true),

            new Course(2, "Thiết kế UI/UX nâng cao", "Trần Thị B", "b@abc.com",
                    "Thiết kế", "Nâng cao", 3200000, 60, "2026-11-15", false),

            new Course(3, "Digital Marketing Cơ bản", "Lê Văn C", "",
                    "Marketing", "Cơ bản", 1200000, 30, "2026-10-20", true),

            new Course(4, "Tiếng Anh giao tiếp Trung cấp", "Phạm Thị D", "d@abc.com",
                    "Ngoại ngữ", "Trung cấp", 2000000, 50, "2026-12-01", false),

            new Course(5, "Java Web nâng cao (Servlet/JSP)", "Hoàng Văn E", "",
                    "Lập trình", "Nâng cao", 4500000, 80, "2026-11-01", true)
    ));
    private static final AtomicInteger idCounter = new AtomicInteger(6);
    public List<Course> getCourses(){
        return  courses;
    }
    public Course getCourseById(int id){
        for (Course course:courses){
            if(course.getId()==id){
                return course;
            }
        }
        return null;
    }
    public void addCourse(Course course){
        course.setId(idCounter.incrementAndGet());
        courses.add(course);
    }
    public Course editCourse(Course course){
        Course exist = getCourseById(course.getId());
        if (exist==null) return null;
        int index = courses.indexOf(exist);
        courses.set(index,course);
        return course;
    }
    public boolean removeCourse(int id){
        Course exist = getCourseById(id);
        if (exist==null) return  false;
        courses.remove(exist);
        return true;
    }
}