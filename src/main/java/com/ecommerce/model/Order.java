package com.ecommerce.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date orderDate;

    @ManyToOne
    private User user;

    private double totalAmount;

    @OneToMany(cascade = CascadeType.ALL)
    private List<CartItem> items;
}