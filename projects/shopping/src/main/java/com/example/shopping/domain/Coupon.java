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

    //TODO: discountPrice나 discountRatio가 NULL일 경우 에러 발생
    @Column(columnDefinition = "INT default 0")
    private int discountPrice;

    @Column(columnDefinition = "DOUBLE default 0.0")
    private double discountRatio;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date expDate;
}
