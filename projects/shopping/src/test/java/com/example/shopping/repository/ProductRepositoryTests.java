package com.example.shopping.repository;

import com.example.shopping.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@DataJpaTest
@Transactional
public class ProductRepositoryTests {
    @Autowired
    ProductRepository productRepository;

    //TODO: 에러 수정 필요
    @Test
    public void id로1건찾기() throws Exception {
        Product product = productRepository.getOne(2L);
        System.out.println(product);
    }
}
