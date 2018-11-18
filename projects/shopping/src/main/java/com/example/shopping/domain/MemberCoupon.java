package com.example.shopping.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "member_coupon")
@IdClass(MemberCouponId.class)
@Getter
@Setter
@ToString
public class MemberCoupon {
    @Id
    @ManyToOne
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;

    @Id
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(columnDefinition = "INT default 0")
    private int quantity;
}
