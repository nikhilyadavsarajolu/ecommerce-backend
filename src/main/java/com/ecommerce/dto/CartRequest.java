package com.ecommerce.dto;

public class CartRequest {
    private Long productId;
    private int quantity;

    // Getter and Setter for productId
    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    // Getter and Setter for quantity
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
