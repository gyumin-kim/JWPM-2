package com.example.shopping.repository;

import com.example.shopping.domain.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class MemberRepositoryTests {
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void id로_멤버_구하기_테스트() throws Exception {
        List<Member> members = memberRepository.findAllById(3L);
        for (Member member : members) {
            System.out.println(member.getId());
            System.out.println(member.getName());
            System.out.println(member.getNickname());
        }
    }

    @Test
    public void 이름_pageable_테스트() throws Exception {
        Pageable pageable = PageRequest.of(0, 5);
        Page<Member> members = memberRepository.findByNameContaining("최", pageable);

        for (Member member : members) {
            System.out.println(member.getName());
            System.out.println(member.getNickname());
        }
    }

    @Test
    public void 이메일_pageable_테스트() throws Exception {
        Pageable pageable = PageRequest.of(0, 5, new Sort(Sort.Direction.ASC, "name"));
        Page<Member> members = memberRepository.findByEmailContaining(".com", pageable);

        for (Member member : members) {
            System.out.println(member.getName());
            System.out.println(member.getNickname());
        }
    }

    @Test
    public void 모든_멤버_가져오기_테스트() throws Exception {
        List<Member> members = memberRepository.findAll();
        for (Member member : members) {
            System.out.println(member.getId());
            System.out.println(member.getName());
            System.out.println(member.getNickname());
        }
    }

    @Test
    public void 멤버_존재여부_테스트() throws Exception {
        boolean exists = memberRepository.existsById(2L);
        if (exists) System.out.println("존재합니다.");
    }

    @Test
    public void 멤버_하나_가져오기() throws Exception {
        Member member = memberRepository.getOne(5L);
        System.out.println(member);
    }
}
