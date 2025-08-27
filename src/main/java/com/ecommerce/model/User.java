package com.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data 
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
    
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;  // default is USER

}
