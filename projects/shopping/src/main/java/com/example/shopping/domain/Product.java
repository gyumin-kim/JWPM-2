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
    private Long number;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int tagPrice;

    @Column(nullable = false)
    private int sellingPrice;

    private int stockQuantity;

    @Column(length = 1000)
    private String description;

    private int maxOrderQuantity;

    @Column(nullable = false)
    private int point;

    // 상품이 카테고리를 참조: 다대일 단방향
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "product")
    private List<OrderedProduct> orderedProducts;

    @ManyToMany
    @JoinTable(name = "product_promotion",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "promotion_id"))
    private List<Promotion> promotions;

    // 상품이 상품이미지들을 참조: 일대다 단방향
    @OneToMany
    @JoinColumn(name = "product_id")
    private List<ProductImage> productImages;
}
