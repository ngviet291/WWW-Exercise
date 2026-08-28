package com.ngviet291.model;

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

    public void incrementQuantity() {
        this.quantity++;
    }
    public void decrementQuantity() {
        if (this.quantity > 0) {
            this.quantity--;
        }
    }
    public BigDecimal getSubtotal() {
        return product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }

}
