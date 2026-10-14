package com.ngviet291.nguyentranquocviet_23660721_tuan05_bai04.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CartItem {
    private Book book;
    private int quantity;
}