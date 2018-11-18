package com.example.shopping.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AddressInfo {
    @Column(nullable = false)
    private String address;

    private String zipCode;
    private String telNumber;
}
