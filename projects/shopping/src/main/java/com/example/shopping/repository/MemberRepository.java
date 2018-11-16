package com.example.shopping.repository;

import com.example.shopping.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findAllById(Long id);
}
