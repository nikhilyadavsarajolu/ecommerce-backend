package com.ecommerce.controller;

import com.ecommerce.model.Order;
import com.ecommerce.security.JwtUtil;
import com.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/place")
    public Order placeOrder(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.substring(7);
        String email = jwtUtil.extractUsername(token);
        System.out.println("Extracted email from token:"+ email);
        return orderService.placeOrder(email);
    }

    @GetMapping("/my-orders")
    public List<Order> getUserOrders(@RequestHeader("Authorization") String authHeader) {
        String email = jwtUtil.extractUsername(authHeader.substring(7));
        return orderService.getOrders(email);
    }
}