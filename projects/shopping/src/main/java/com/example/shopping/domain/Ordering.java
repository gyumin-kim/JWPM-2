package com.example.shopping.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ordering")
@Getter
@Setter
@ToString
public class Ordering {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20)
    private Long number;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private int discountPrice;

    @Column(nullable = false)
    private int reservedMoney;

    @Column(nullable = false)
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @OneToMany(mappedBy = "ordering")
    private List<OrderedProduct> orderedProducts;

    @OneToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;
}
