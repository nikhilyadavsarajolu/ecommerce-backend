package com.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data // <-- This auto-generates getters/setters
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String name;
    private String password;
    private String role;
}
