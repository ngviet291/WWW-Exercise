package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Product {
    private int id;
    private String model;
    private String description;
    private int quantity;
    private double price;
    private String imgUrl;
}
