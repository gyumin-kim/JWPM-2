package com.example.shopping.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
@Setter
@Getter
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long Number;

    @Column(nullable = false)
    private Long name;

    @Column(nullable = false)
    private int price;

    private int discountedPrice;

    @Column(nullable = false)
    private int stockQuantity;

    private String description;
    private int maxOrderQuantity;
    private int point;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<CartProduct> cartProducts;

    @OneToMany(mappedBy = "product")
    private List<OrderedProduct> orderedProducts;

    @ManyToMany
    @JoinTable(name = "product_wish_list",
                joinColumns = @JoinColumn(name = "product_id"),
                inverseJoinColumns = @JoinColumn(name = "wish_list_id"))
    private List<WishList> wishLists;
}
