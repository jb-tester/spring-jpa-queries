package com.mytests.spring.jpa.springjpaqueries.services;

import com.mytests.spring.jpa.springjpaqueries.data.Sample;
import com.mytests.spring.jpa.springjpaqueries.repositories.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * *
 * <p>Created by irina on 23.01.2021.</p>
 * <p>Project: spring-jpa-queries</p>
 * *
 */
@Service
public class SampleService {

    private final SampleRepository sampleRepository;

    public SampleService(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

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
    public void findAndUpdateAllSamplesInList(){
        System.out.println("================== find, update and find again: ");
        System.out.println("-- initial:");
        for (Sample sample : sampleRepository.getAllRedSamplesWithSpecificNames()) {
            System.out.println(sample.toString());
        }
        sampleRepository.queryAllBySampleNamesAndUpdateNameAndColor("updated_name");
        System.out.println("-- resulted:");
        for (Sample sample : sampleRepository.findAll()) {
            System.out.println(sample.toString());
        }
    }
}
