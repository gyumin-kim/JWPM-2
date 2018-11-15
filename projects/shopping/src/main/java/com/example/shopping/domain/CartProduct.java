package com.example.shopping.domain;

import com.sun.org.apache.bcel.internal.generic.DADD;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cart_product")
@IdClass(CartProductId.class)
@Getter
@Setter
@ToString
public class CartProduct {
    @Id
    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private Date addedDate;
}
