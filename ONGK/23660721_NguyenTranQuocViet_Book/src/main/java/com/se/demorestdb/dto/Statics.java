package com.se.demorestdb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Statics {
    private int id;
    private String name;
    private int bookCount;
    private Double totalPrice;
    private Double avgPrice;
}
