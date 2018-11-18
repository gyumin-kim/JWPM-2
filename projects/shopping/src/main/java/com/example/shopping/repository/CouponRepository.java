package com.example.shopping.repository;

import com.example.shopping.domain.Coupon;
import com.example.shopping.domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
    Coupon getOne(Long id);

//    @Query(value = "SELECT c FROM Coupon c WHERE c.discountPrice BETWEEN :start AND :end")
//    List<Coupon> findCouponsByDiscountPriceBetween(@Param("start") int start, @Param("end") int end);

    @Query(value = "SELECT c from Coupon c WHERE c.name LIKE concat('%', :name, '%')")
    List<Coupon> findByNameContaining(@Param("name") String name);
}
