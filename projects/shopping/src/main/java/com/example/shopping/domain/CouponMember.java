package com.example.shopping.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "coupon_member")
@IdClass(CouponMemberId.class)
@Getter
@Setter
@ToString
public class CouponMember {
    @Id
    @ManyToOne
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;

    @Id
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private boolean used;
}
