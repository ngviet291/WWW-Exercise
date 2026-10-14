package com.ngviet291.nguyentranquocviet_23660721_tuan05_bai04.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Cart {

    private final List<CartItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Book book) {

        if (book == null) {
            return;
        }

        for (CartItem cartItem : items) {

            if (cartItem.getBook() == null) {
                continue;
            }

            if (cartItem.getBook().getBookId().equals(book.getBookId())) {
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                return;
            }
        }

        CartItem item = CartItem.builder()
                .book(book)
                .quantity(1)
                .build();

        items.add(item);
    }

    public void removeItem(String bookId) {

        items.removeIf(cartItem -> cartItem.getBook() != null
                && cartItem.getBook().getBookId().equals(bookId));
    }

    public double getTotalPrice() {

        double total = 0;

        for (CartItem item : items) {

            if (item.getBook() == null) {
                continue;
            }

            double price = item.getBook().getPrice();
            int quantity = item.getQuantity();

            total += price * quantity;
        }

        return total;
    }

    public void clear() {
        items.clear();
    }
}