package com.example.shopping.repository;

import com.example.shopping.domain.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findAll();
    Page<Member> findAll(Pageable pageable);
    List<Member> findAllById(Long id);
    Page<Member> findAllById(Long id, Pageable pageable);

    boolean existsById(Long id);
    //    List<Member> findAllByEmailAndAddressInfo();

    @Query(value = "SELECT m from Member m WHERE m.name LIKE concat('%', :name, '%')")
    Page<Member> findByNameContaining(@Param("name") String name, Pageable pageable);

    @Query(value = "SELECT m from Member m WHERE m.email LIKE concat('%', :email, '%')")
    Page<Member> findByEmailContaining(@Param("email") String email, Pageable pageable);

    Member getOne(Long id);

    void delete(Member member);
}
