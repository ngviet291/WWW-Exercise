package com.ngviet291.nguyentranquocviet_23660721_bai03.model;

import lombok.*;

import java.io.Serializable;
import java.util.List;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class GradeReport implements Serializable {
    private String id;
    private String name;
    private String semester;
    private String[] subjects;
}
