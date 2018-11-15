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
    @Column(name = "coupon_id")
    private Long id;

    @Column(length = 45, nullable = false) @NotNull
    private String name;

    private int discountPrice;
    private double discountRatio;
    private Date expDate;

//    @OneToMany(mappedBy = "coupon")
//    private List<MemberCoupon> memberCoupons;
}
