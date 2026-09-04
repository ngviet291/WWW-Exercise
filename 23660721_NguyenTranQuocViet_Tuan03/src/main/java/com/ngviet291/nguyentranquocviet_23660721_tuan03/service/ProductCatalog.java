package com.ngviet291.nguyentranquocviet_23660721_tuan03.service;

import com.ngviet291.nguyentranquocviet_23660721_tuan03.model.Product;
import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigDecimal;
import java.util.List;

@ApplicationScoped
public class ProductCatalog {
    private final List<Product> products= List.of(
            new Product(1,"Laptop", new BigDecimal("1500.00")),
            new Product(2,"Keyboard",new BigDecimal("80.00")),
            new Product(3,"Mouse", new BigDecimal("40.00")));
    public List<Product> getProducts() {
        return products;
    }
    public Product getProductById(long id){
        return products.stream().filter(product -> product.getId()==id).findFirst().orElse(null);
    }
}