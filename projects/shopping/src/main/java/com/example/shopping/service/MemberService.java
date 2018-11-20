package com.example.shopping.service;

import com.example.shopping.domain.Product;
import org.springframework.data.domain.Page;

public interface ProductService {
    Page<Product> getAllProductsPaging();
}
