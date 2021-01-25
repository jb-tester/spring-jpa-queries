package com.mytests.spring.jpa.springjpaqueries.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IssuesRepository extends CrudRepository<Issues,Long> {

    List<Issues> findAll();
    @Query("select iss from Issues iss where iss.priority = com.mytests.spring.jpa.springjpaqueries.utils.PriorityEnum.Medium")
    List<Issues> findByExplicitQuery1();

    List<Issues> findOpenIssues();
}
