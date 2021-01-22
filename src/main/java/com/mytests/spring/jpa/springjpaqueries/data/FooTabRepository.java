package com.mytests.spring.jpa.springjpaqueries.data;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * *
 * <p>Created by irina on 23.01.2021.</p>
 * <p>Project: spring-jpa-queries</p>
 * *
 */
public interface FooTabRepository extends CrudRepository<Footab, Integer> {
    
    List<Footab> findAll();
}
