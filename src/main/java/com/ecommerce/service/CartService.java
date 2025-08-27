package com.ecommerce.service;

import com.ecommerce.dto.CartResponse;
import com.ecommerce.model.CartItem;
import com.ecommerce.model.Product;
import com.ecommerce.model.User;
import com.ecommerce.repository.CartItemRepository;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.repository.UserRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    public CartResponse addToCart(String email, Long productId, int quantity) {
    User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));
    Product product = productRepository.findById(productId)
            .orElseThrow(() -> new RuntimeException("Product not found"));

    CartItem item = CartItem.builder()
            .user(user)
            .product(product)
            .quantity(quantity)
            .build();

    item.setQuantity(item.getQuantity() + quantity);
    CartItem savedItem = cartItemRepository.save(item);

    // Map entity → DTO
    CartResponse response = new CartResponse();
    response.setCartItemId(savedItem.getId());
    response.setProductId(product.getId());
    response.setProductName(product.getName());
    response.setProductPrice(product.getPrice());
    response.setQuantity(savedItem.getQuantity());
    response.setTotalPrice(product.getPrice().multiply(BigDecimal.valueOf(savedItem.getQuantity())));

    return response;
}


    public List<CartResponse> getCart(String email) {
    User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));

    List<CartItem> cartItems = cartItemRepository.findByUser(user);

    List<CartResponse> responseList = new ArrayList<>();
    for (CartItem item : cartItems) {
        CartResponse response = new CartResponse();
        response.setCartItemId(item.getId());
        response.setProductId(item.getProduct().getId());
        response.setProductName(item.getProduct().getName());
        response.setProductPrice(item.getProduct().getPrice());
        response.setQuantity(item.getQuantity());

        // BigDecimal multiplication
        response.setTotalPrice(
            item.getProduct().getPrice().multiply(BigDecimal.valueOf(item.getQuantity()))
        );

        responseList.add(response);
    }
    return responseList;
}



   @Transactional
public void removeFromCart(String email, Long productId) {
    User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));

    Product product = productRepository.findById(productId)
            .orElseThrow(() -> new RuntimeException("Product not found"));

    CartItem item = cartItemRepository.findByUserAndProduct(user, product)
            .orElseThrow(() -> new RuntimeException("Product not found in cart"));

    cartItemRepository.delete(item);
}

}
