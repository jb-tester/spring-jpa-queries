package com.mytests.spring.jpa.springjpaqueries.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * *
 * <p>Created by irina on 23.01.2021.</p>
 * <p>Project: spring-jpa-queries</p>
 * *
 */
@Service
public class FooTabService {

    @Autowired
    private FooTabRepository fooTabRepository;
    
    public void displayAll(){
        for (Footab footab : fooTabRepository.findAll()) {
            System.out.println(footab.toString());
        }
    }
}
