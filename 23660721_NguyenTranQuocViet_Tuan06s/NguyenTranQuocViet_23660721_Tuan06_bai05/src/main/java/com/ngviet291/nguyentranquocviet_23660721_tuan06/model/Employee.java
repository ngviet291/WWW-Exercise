package com.ngviet291.nguyentranquocviet_23660721_tuan06.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Employee {
    private int id;
    private String name;
    private BigDecimal salary;
}
