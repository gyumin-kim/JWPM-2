package com.example.shopping.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "claim")
@Getter
@Setter
@ToString
public class Claim {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String type;

    @Column(nullable = false)
    private String reason;

    private int price;

    @OneToOne
    @JoinColumn(name = "ordered_product_id")
    private OrderedProduct orderedProduct;
}
