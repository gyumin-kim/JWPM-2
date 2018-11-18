package com.example.shopping.domain;

import javax.persistence.Embeddable;

@Embeddable
public class PhysicalInfo {
    private int height;
    private int weight;
    private String sex;
    private String birthDate;
}
