package com.example.shopping.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "delivery_company")
@Getter
@Setter
@ToString
public class DeliveryCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String corpNumber;

    private String telNumber;

    @Column(nullable = false)
    private String address;

    private String accountNumber;
    private String depositor;

    @OneToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;
}
