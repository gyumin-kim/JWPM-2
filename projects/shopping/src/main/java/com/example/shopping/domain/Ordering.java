package com.example.shopping.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ordering")
@Getter
@Setter
@ToString
public class Ordering {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int number;
    private Date date;
    private int price;
    private int discountPrice;
    private int reservedMoney;
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
