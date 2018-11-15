package com.example.shopping.domain;

import java.io.Serializable;

public class MemberCouponId implements Serializable {
    private Coupon coupon;
    private Member member;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
