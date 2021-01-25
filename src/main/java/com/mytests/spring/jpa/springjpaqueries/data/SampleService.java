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
public class SampleService {

    @Autowired
    private SampleRepository sampleRepository;
    
    public void displayAll(){
        System.out.println("================ findAll(): ");
        for (Sample sample : sampleRepository.findAll()) {
            System.out.println(sample.toString());
        }
    }
    public void displayByColorCriteria(){
        System.out.println("================== findByColorCriteria: ");
        for (String s : sampleRepository.findBySpecifiedQuery1()) {
            System.out.println(s);
        }
    }
}
