package com.example.shopping.repository;

import com.example.shopping.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product getOne(Long id);
    List<Product> findAll();
    Page<Product> findAll(Pageable pageable);

    List<Product> findAllByNumber(Long number);
    Page<Product> findAllByNumber(Long number, Pageable pageable);

    List<Product> findAllByName(String name);
    Page<Product> findAllByName(String name, Pageable pageable);
    @Query(value = "SELECT p from Product p WHERE p.name LIKE concat('%', :name, '%')")
    Page<Product> findByNameContaining(@Param("name") String name, Pageable pageable);

    @Query(value = "SELECT p FROM Product p WHERE p.tagPrice BETWEEN :start AND :end")
    List<Product> findProductsByTagPriceBetween(@Param("start") int start, @Param("end") int end);
    @Query(value = "SELECT p FROM Product p WHERE p.sellingPrice BETWEEN :start AND :end")
    List<Product> findProductsBySellingPriceBetween(@Param("start") int start, @Param("end") int end);

    @Query(value = "SELECT p from Product p WHERE p.description LIKE concat('%', :description, '%')")
    Page<Product> findByDescriptionContaining(@Param("description") String description, Pageable pageable);

    List<Product> findAllByCategory(String category);
    Page<Product> findAllByCategory(String category, Pageable pageable);

    void delete(Product product);

    boolean existsById(Long id);
}
