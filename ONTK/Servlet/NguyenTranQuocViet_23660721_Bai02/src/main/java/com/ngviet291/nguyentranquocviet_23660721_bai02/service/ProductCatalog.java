package com.ngviet291.nguyentranquocviet_23660721_bai02.service;

import com.ngviet291.nguyentranquocviet_23660721_bai02.model.Product;
import jakarta.enterprise.context.ApplicationScoped;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@ApplicationScoped
public class ProductCatalog {
    private final List<Product> products= new ArrayList<>(List.of(
            new Product(1,"CAs",new BigDecimal(43222)),
            new Product(2,"dassd",new BigDecimal(1200))
    ));
    public List<Product> findAll(){
        return products;
    }
    public Product findById(int id){
        for (Product product:products){
            if(product.getId()==id){
                return product;
            }

        }
        return null;
    }
}
