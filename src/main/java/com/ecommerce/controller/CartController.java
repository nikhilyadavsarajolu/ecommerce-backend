package com.ecommerce.controller;

import com.ecommerce.dto.CartRequest;
import com.ecommerce.dto.CartResponse;
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
public CartResponse addToCart(
    @RequestHeader("Authorization") String authHeader,
    @RequestBody CartRequest request) {
    String email = jwtUtil.extractUsername(authHeader.substring(7));
    return cartService.addToCart(email, request.getProductId(), request.getQuantity());
}


    @GetMapping("/view")
public ResponseEntity<List<CartResponse>> viewCart(@RequestHeader("Authorization") String authHeader) {
    try {
        String token = authHeader.substring(7); // Remove "Bearer "
        String email = jwtUtil.extractUsername(token);

        List<CartResponse> cartItems = cartService.getCart(email);

        return ResponseEntity.ok(cartItems);
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(null);
    }
}



@DeleteMapping("/remove/{productId}")
public ResponseEntity<String> removeFromCart(
        @RequestHeader("Authorization") String authHeader,
        @PathVariable Long productId) {
    try {
        String email = jwtUtil.extractUsername(authHeader.substring(7));

        cartService.removeFromCart(email, productId);

        return ResponseEntity.ok("✅ Product removed from cart successfully");
    } catch (RuntimeException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("❌ " + e.getMessage());
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("⚠️ Something went wrong while removing product from cart");
    }
}

}
