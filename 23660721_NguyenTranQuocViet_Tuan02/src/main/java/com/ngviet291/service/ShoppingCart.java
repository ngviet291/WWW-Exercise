package com.ngviet291.service;

import com.ngviet291.model.CartItem;
import com.ngviet291.model.Product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart implements Serializable {
    private final List<CartItem> items= new ArrayList<>();
    public void addItem(Product product){
        for (CartItem item: items){
            if (item.getProduct().getId()==product.getId()){
                item.incrementQuantity();
                return;
            }
        }
        items.add(new CartItem(product));
    }
    public List<CartItem> getItems(){
        return items;
    }
    public void removeItem(long productId){
        items.removeIf(cartItem -> cartItem.getProduct().getId()==productId);
    }
    public int getItemCount(){
        return items.stream().mapToInt(CartItem::getQuantity).sum();
    }
    public BigDecimal getTotal(){
        return items.stream().map(CartItem::getSubtotal).reduce(BigDecimal.ZERO,BigDecimal::add);
    }
}
