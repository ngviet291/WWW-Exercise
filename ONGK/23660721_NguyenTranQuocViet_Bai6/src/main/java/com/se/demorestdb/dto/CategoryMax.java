package com.se.demorestdb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryMax {
    private int id;
    private String title;
    private int quantity;
}
