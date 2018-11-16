package com.example.shopping;

import com.example.shopping.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ShoppingApplicationTests {

	@Autowired
	MemberRepository memberRepository;

	@Test
	public void contextLoads() {
	}
}
