package com.mytests.spring.jpa.springjpaqueries;

import com.mytests.spring.jpa.springjpaqueries.repositories.SampleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringJpaQueriesApplicationTests {

    @Autowired
    SampleRepository repository;
    @Test
    void contextLoads() {
        repository.findAll().forEach(e -> repository.delete(e));
    }

}
