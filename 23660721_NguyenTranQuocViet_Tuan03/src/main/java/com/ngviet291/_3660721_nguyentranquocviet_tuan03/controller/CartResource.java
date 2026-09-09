package com.ngviet291._3660721_nguyentranquocviet_tuan03.controller;

import com.ngviet291._3660721_nguyentranquocviet_tuan03.model.Product;
import com.ngviet291._3660721_nguyentranquocviet_tuan03.service.ProductCatalog;
import com.ngviet291._3660721_nguyentranquocviet_tuan03.service.ShoppingCart;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import java.util.List;

@Path("/cart")
public class CartResource {
    @Inject
    private ProductCatalog productCatalog;
    @Inject
    private ShoppingCart shoppingCart;

    @GET
    @Path("/allProducts")
    public List<Product> getAllProducts() {
        return productCatalog.getProducts();
    }
    @POST
    @Path("/add/{productId}")
    public String addProductToCart(@PathParam("productId") long productId) {
        Product product = productCatalog.getProductById(productId);
        if (product != null) {
            shoppingCart.addItem(product);
            return "Product added to cart: " + product.getName();
        } else {
            return "Product not found";
        }
    }
    @GET
    @Path("/items")
    public ShoppingCart getCartItems() {
        return shoppingCart;
    }

    @POST
    @Path("/remove/{productId}")
    public String removeProductFromCart(@PathParam("productId") long productId) {
        shoppingCart.removeItem(productId);
        return "Product removed from cart with ID: " + productId;
    }
    @GET
    @Path("/count")
    public int getItemCount() {
        return shoppingCart.getItemCount();
    }
}
