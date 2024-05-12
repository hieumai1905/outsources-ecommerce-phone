package com.example.ecommercesmartphone.models;

public class CartItem {
    private ProductVersion productVersion;
    private int quantity;

    public CartItem(ProductVersion productVersion) {
        this.productVersion = productVersion;
        this.quantity = 1;
    }

    public ProductVersion getProductVersion() {
        return productVersion;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}