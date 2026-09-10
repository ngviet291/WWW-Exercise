package com.ngviet291.nguyentranquocviet_23660721_bai02.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class CartItem implements Serializable {
    private final Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = 1;
    }
    public void increasement(){
        this.quantity++;
    }
    public BigDecimal getSubTotal(Product product){
        return product.getPrice().multiply(new BigDecimal(quantity));
    }
}
