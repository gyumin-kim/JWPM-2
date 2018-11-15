//package com.example.shopping.domain;
//
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
//import javax.persistence.*;
//import java.util.Date;
//import java.util.List;
//
//@Entity
//@Table(name = "cart")
//@Getter
//@Setter
//@ToString
//public class Cart {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(nullable = false)
//    private int quantity;
//
//    @Column(nullable = false)
//    private Date expDate;
//
//    @Column(nullable = false)
//    private int total;
//
//    @OneToMany(mappedBy = "cart")
//    private List<CartProduct> cartProducts;
//}
