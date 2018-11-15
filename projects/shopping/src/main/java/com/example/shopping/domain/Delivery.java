package com.example.shopping.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "delivery")
@Getter
@Setter
@ToString
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String recipientName;
    private String address;
    private String recipientPhone;
    private String message;
    private int fee;

    @OneToOne
    @JoinColumn(name = "ordering_id")
    private Ordering ordering;

    @OneToOne
    @JoinColumn(name = "delivery_company_id")
    private DeliveryCompany deliveryCompany;
}
