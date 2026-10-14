package com.se.demorestdb.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Book {
    private int id;
    private String title;
    private String author;
    private double price;
    private int publisherId;
}
