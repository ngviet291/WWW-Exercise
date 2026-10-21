package com.se.demorestdb.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class PublisherSumPriceDto {
    private int id;
    private String name;
    private double totalPrice;
}
