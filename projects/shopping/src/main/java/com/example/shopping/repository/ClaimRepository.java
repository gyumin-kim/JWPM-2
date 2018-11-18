package com.example.shopping.repository;

import com.example.shopping.domain.Claim;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClaimRepository extends JpaRepository<Claim, Long> {
    Claim getClaimById(Long id);

    @Query(value = "SELECT c from Claim c WHERE c.price >= :price")
    List<Claim> findClaimsByPriceAfter(@Param("price") int price);

    @Query(value = "SELECT c from Claim c WHERE c.reason LIKE concat('%', :reason, '%')")
    Page<Claim> findByReasonContaining(@Param("reason") String reason, Pageable pageable);

    @Query(value = "SELECT c from Claim c WHERE c.type LIKE concat('%', :type, '%')")
    Page<Claim> findByTypeContaining(@Param("type") String type, Pageable pageable);
}
