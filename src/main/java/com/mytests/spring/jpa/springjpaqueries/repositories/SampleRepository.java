package com.mytests.spring.jpa.springjpaqueries.repositories;

import com.mytests.spring.jpa.springjpaqueries.data.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * *
 * <p>Created by irina on 23.01.2021.</p>
 * <p>Project: spring-jpa-queries</p>
 * *
 */
@Repository("sampleRepository")
public interface SampleRepository extends JpaRepository<Sample, Integer> {
    
    List<Sample> findAll();

    @Query("select s.sample from Sample s where s.color = com.mytests.spring.jpa.springjpaqueries.utils.CriteriaProvider.COLORCRITERIA ")
    List<String> findBySpecifiedQuery1();
}
