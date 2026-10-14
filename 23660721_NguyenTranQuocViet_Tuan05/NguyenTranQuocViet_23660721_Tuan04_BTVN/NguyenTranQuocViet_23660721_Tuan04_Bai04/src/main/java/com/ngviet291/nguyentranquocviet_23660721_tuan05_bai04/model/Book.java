package com.ngviet291.nguyentranquocviet_23660721_tuan05_bai04.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Book {
    private String bookId;
    private String title;
    private String author;
    private double price;
    private int quantity;
    private String image;

}
