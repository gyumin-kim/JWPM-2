package com.example.shopping.domain;

import java.io.Serializable;

public class CartProductId implements Serializable {
    private Cart cart;
    private Product product;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
