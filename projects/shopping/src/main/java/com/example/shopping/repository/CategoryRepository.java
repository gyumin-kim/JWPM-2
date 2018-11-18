package com.example.shopping.repository;

import com.example.shopping.domain.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category getOne(Long id);

    @Query(value = "SELECT c from Category c WHERE c.name LIKE concat('%', :name, '%')")
    Page<Category> findByNameContaining(@Param("name") String name, Pageable pageable);
}
