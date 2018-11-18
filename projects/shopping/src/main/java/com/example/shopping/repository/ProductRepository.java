package com.example.shopping.repository;

import com.example.shopping.domain.Category;
import com.example.shopping.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product getOne(Long id);

    @Query(value = "SELECT p from Product p WHERE p.name LIKE concat('%', :name, '%')")
    Page<Category> findByNameContaining(@Param("name") String name, Pageable pageable);
}
