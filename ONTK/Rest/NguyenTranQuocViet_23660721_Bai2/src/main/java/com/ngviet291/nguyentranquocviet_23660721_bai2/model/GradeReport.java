package com.ngviet291.nguyentranquocviet_23660721_bai2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GradeReport {
    private String studentId;
    private String studentName;
    private String semester;
    private List<String> selectedSubjects;
}
