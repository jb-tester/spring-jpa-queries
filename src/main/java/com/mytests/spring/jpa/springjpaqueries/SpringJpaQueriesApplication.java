package com.mytests.spring.jpa.springjpaqueries;

import com.mytests.spring.jpa.springjpaqueries.data.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJpaQueriesApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaQueriesApplication.class, args);
    }
     @Autowired
    ApplicationContext ctx;
    @Override
    public void run(String... args) throws Exception {
        ctx.getBean(SampleService.class).displayAll();
    }
}
