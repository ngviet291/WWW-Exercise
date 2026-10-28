package com.ngviet291._3660721_nguyentranquocviet_jdbc1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "employees")
public class Employee {
    @Id
    private Integer id;
    private String name;
    private String role;
    private int age;
    private double salary;
    private Integer department_id;
    private Integer position_id;
}
