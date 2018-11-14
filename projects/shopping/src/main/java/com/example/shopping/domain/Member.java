package com.example.shopping.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "member")
@Setter
@Getter
@ToString
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;

    @Column(length = 20, nullable = false) @NotNull
    private String name;
    private String nickname;
    private String password;

    @Column(length = 15, nullable = false) @NotNull
    private String phone;
    private String address;
    private String zipCode;
    private int height;
    private int weight;
    private String sex;
    private String birthDate;
    private int point;

//    @ManyToOne
//    @JoinColumn(name = "grade_id")
//    private Grade grade;

//    @ManyToMany
//    @JoinTable(name = "member_coupon", // 연결 테이블을 지정
//                joinColumns = @JoinColumn(name = "member_id"),  // 멤
//                inverseJoinColumns = @JoinColumn(name = "coupon_id"))
//    private List<Coupon> coupons;

    @OneToMany(mappedBy = "member")
    private List<CouponMember> couponMembers;
}
