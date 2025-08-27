package com.ecommerce.controller;

import com.ecommerce.dto.RegisterRequest;
import com.ecommerce.model.User;
import com.ecommerce.security.JwtUtil;
import com.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    // User registration
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest request) {
        try {
            User savedUser = userService.registerUser(request);
            return ResponseEntity.ok(savedUser);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    // User login and JWT token generation
  @PostMapping("/login")
public ResponseEntity<?> loginUser(@RequestBody User loginRequest) {
    Optional<User> optionalUser = userService.findByEmail(loginRequest.getEmail());

    if (optionalUser.isPresent()) {
        User user = optionalUser.get();

        // Debug logs
        System.out.println("Raw input password: " + loginRequest.getPassword());
        System.out.println("Encoded password from DB: " + user.getPassword());

        boolean isMatch = passwordEncoder.matches(loginRequest.getPassword(), user.getPassword());
        System.out.println("Password match result: " + isMatch);

        if (isMatch) {
            String token = jwtUtil.generateToken(user.getEmail());
            return ResponseEntity.ok(Collections.singletonMap("token", token));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid password");
        }
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
    }
}
}
