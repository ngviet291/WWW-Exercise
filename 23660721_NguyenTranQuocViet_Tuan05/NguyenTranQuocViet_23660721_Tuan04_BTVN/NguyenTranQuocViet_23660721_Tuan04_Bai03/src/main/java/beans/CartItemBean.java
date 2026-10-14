package beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Product;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartItemBean implements Serializable {
    private Product product;
    private int quantity;

    public double getSubtotal() {

        return product.getPrice() * quantity;

    }

}
