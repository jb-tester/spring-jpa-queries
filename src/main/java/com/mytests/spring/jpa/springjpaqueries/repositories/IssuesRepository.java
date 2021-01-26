package com.mytests.spring.jpa.springjpaqueries.repositories;

import com.mytests.spring.jpa.springjpaqueries.data.Issues;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IssuesRepository extends CrudRepository<Issues,Long> {

    List<Issues> findAll();
    
    // Named queries:
    // the Issues.findByPriorityEnum query
    List<Issues> findByPriorityEnum();
    // the Issues.findOpenIssues query
    List<Issues> findOpenIssues();

    // Explicit queries:
    @Query("select issue from Issues issue where issue.priority = com.mytests.spring.jpa.springjpaqueries.utils.PriorityEnum.Medium")
    List<Issues> findByExplicitQuery1();
    
    List<Long> findIdByTitleContains(String title);
    
    @Query("select issue.title from Issues issue where issue.title like %:pattern% or issue.description like %:pattern%")
    List<String> findTitlesByKeyword(@Param("pattern") String pattern);
}
