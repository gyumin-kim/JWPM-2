package com.example.shopping.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payment")
@Getter
@Setter
@ToString
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date paymentDate;

    @Column(nullable = false)
    private String method;

    @Column(nullable = false)
    private Long paymentNumber;

    @Column(nullable = false)
    private String cardCompany;

    @Column(nullable = false)
    private String bank;

    @Column(nullable = false)
    private int fee;

//    @OneToOne
//    @JoinColumn(name = "ordering_id")
//    private Ordering ordering;
}
