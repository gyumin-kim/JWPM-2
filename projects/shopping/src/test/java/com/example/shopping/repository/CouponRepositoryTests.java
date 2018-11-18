package com.example.shopping.repository;

import com.example.shopping.domain.Coupon;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class CouponRepositoryTests {
    @Autowired
    CouponRepository couponRepository;

//    @Test
//    public void 쿠폰가격범위에따라리스트구하기() throws Exception {
//        List<Coupon> coupons = couponRepository.findCouponsByDiscountPriceBetween(5000, 20000);
//        for (Coupon coupon : coupons) {
//            System.out.println(coupon);
//        }
//    }

    @Test
    public void 쿠폰이름검색() throws Exception {
        List<Coupon> coupons = couponRepository.findByNameContaining("11월");
        for (Coupon coupon : coupons) {
            System.out.println(coupon);
        }
    }
}
