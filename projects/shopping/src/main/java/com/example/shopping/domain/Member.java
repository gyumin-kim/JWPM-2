package com.example.shopping.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
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

    @Column(length = 20, nullable = false)
    private String name;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String password;

    @Column(length = 15, nullable = false)
    private String phone;

    @Column(nullable = false)
    private String address;

    private String zipCode;
    private int height;
    private int weight;
    private String sex;
    private String birthDate;

    @Column(nullable = false)
    private int point;

    @ManyToOne
    @JoinColumn(name = "grade_id")
    private Grade grade;

    @OneToMany(mappedBy = "member")
    private List<MemberCoupon> memberCoupons;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @OneToOne
    @JoinColumn(name = "wish_list_id")
    private WishList wishList;

    @OneToMany(mappedBy = "member")
    private List<Ordering> orderings;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;
}
