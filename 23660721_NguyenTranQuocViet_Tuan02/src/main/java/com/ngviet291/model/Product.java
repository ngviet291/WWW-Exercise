package com.ngviet291.model;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class Product implements Serializable {
    private final long id;
    private final String name;
    private final BigDecimal  price;
}