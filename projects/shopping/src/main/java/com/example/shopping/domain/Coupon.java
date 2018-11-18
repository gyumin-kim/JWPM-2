package com.example.shopping.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "coupon")
@Getter
@Setter
@ToString
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45, nullable = false)
    private String name;

    @Column(columnDefinition = "INT default NULL")
    private int discountPrice;

    @Column(columnDefinition = "DOUBLE default NULL")
    private double discountRatio;

    @Column(nullable = false)
    private Date expDate;
}
