package com.ngviet291.nguyentranquocviet_23660721_test1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course implements Serializable {
    private String courseId;
    private String courseName;
    private String instructor;
}
