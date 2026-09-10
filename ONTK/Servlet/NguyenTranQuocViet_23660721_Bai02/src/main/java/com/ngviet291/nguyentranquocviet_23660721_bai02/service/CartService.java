package com.ngviet291.nguyentranquocviet_23660721_bai02.service;

import com.ngviet291.nguyentranquocviet_23660721_bai02.model.CartItem;
import com.ngviet291.nguyentranquocviet_23660721_bai02.model.Product;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CartService implements Serializable {
    public List<CartItem> cartItems = new ArrayList<>();
    public void addProduct(Product product) {
        for (CartItem c : cartItems) {
            if (c.getProduct().getId() == product.getId()) {
                c.setQuantity(c.getQuantity() + 1);
                return;
            }
        }

        cartItems.add(new CartItem(product, 1));
    }

    public List<CartItem> getItems(){
        return cartItems;
    }
    public int getCountCartItem(){
        return cartItems.stream().mapToInt(CartItem::getQuantity).sum();
    }
}
