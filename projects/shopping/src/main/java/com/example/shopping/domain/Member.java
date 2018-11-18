package com.example.shopping.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "member")
@Setter
@Getter
@ToString
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)
    private String email;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String nickname;

    @Column(length = 20, nullable = false)
    private String password;

    @Column(length = 15, nullable = false)
    private String phone;

    @Embedded AddressInfo addressInfo;
    @Embedded PhysicalInfo physicalInfo;

    @Column(nullable = false)
    private int point;

    @OneToMany(mappedBy = "member")
    private List<MemberCoupon> memberCoupons;

    @OneToMany(mappedBy = "member")
    private List<Ordering> orderings;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "grade_id")
    private Grade grade;

    // 회원과 장바구니상품: 일대다 단방향
    @OneToMany
    @JoinColumn(name = "member_id")
    private List<CartProduct> cartProducts;

    @ManyToMany
    @JoinTable(name = "wish_list_member_product",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> wishListSet;
}
