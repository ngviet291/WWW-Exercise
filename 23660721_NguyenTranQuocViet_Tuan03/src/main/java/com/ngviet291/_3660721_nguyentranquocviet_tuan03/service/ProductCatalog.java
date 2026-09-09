package com.ngviet291._3660721_nguyentranquocviet_tuan03.service;
import com.ngviet291._3660721_nguyentranquocviet_tuan03.model.Product;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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