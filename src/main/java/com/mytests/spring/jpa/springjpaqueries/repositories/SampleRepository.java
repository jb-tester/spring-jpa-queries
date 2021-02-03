package com.mytests.spring.jpa.springjpaqueries.repositories;

import com.mytests.spring.jpa.springjpaqueries.data.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * *
 * <p>Created by irina on 23.01.2021.</p>
 * <p>Project: spring-jpa-queries</p>
 * *
 */
@Repository("sampleRepository")
public interface SampleRepository extends JpaRepository<Sample, Integer> {

    String SAMPLENAMES = "'sample14','sample16', 'sample18', 'sample20', 'sample22'";
    String COLOR = "white";

    List<Sample> findAll();

    @Query("select s.sample from Sample s where s.color = com.mytests.spring.jpa.springjpaqueries.utils.CriteriaProvider.COLORCRITERIA ")
    List<String> findBySpecifiedQuery1();
    
    @Query("select s from Sample s where s.sample in (" + SAMPLENAMES + ") and s.color= 'red'")
    List<Sample> getAllRedSamplesWithSpecificNames();
    
    @Transactional @Modifying
    @Query("update Sample set sample = :newName, color = '" + COLOR + "', version = 2 where sample in (" + SAMPLENAMES + ")")
    void queryAllBySampleNamesAndUpdateNameAndColor(@Param("newName") String newName);
}
