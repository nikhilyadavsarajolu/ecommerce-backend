package com.ecommerce.controller;

import com.ecommerce.model.CartItem;
import com.ecommerce.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.ecommerce.security.JwtUtil;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private JwtUtil jwtUtil;

   @PostMapping("/add")
public CartItem addToCart(
    @RequestHeader("Authorization") String authHeader,
    @RequestParam Long productId,
    @RequestParam int quantity) {
    String email = jwtUtil.extractUsername(authHeader.substring(7));
    return cartService.addToCart(email, productId, quantity);
}

    @GetMapping("/view")
public List<CartItem> viewCart(@RequestHeader("Authorization") String authHeader) {
    String token = authHeader.substring(7); // Remove "Bearer "
    String email = jwtUtil.extractUsername(token);
    return cartService.getCart(email);
}

 @DeleteMapping("/remove/{productId}")
public ResponseEntity<String> removeFromCart(
        @RequestHeader("Authorization") String authHeader,
        @PathVariable Long productId) {
    try {
        String email = jwtUtil.extractUsername(authHeader.substring(7));
        cartService.removeFromCart(email, productId);
        return ResponseEntity.ok("Product removed from cart");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: " + e.getMessage());
    }
}
}
