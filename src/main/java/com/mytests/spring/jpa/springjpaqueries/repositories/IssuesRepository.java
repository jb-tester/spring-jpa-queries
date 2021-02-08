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
    // the Issues.useConcatenation query
    List<Issues> useConcatenation();
    // query from jpa-named-queries.properties: 
    List<Issues> namedQueryFromProperties(String author, Issues.StateEnum state);
    
    
    // Explicit queries:
    @Query("select issue from Issues issue where issue.priority = com.mytests.spring.jpa.springjpaqueries.utils.PriorityEnum.Medium")
    List<Issues> findByExplicitQuery1();
    
    @Query("select issue.title from Issues issue where issue.title like %:pattern% or issue.description like %:pattern%")
    List<String> findTitlesByKeyword(@Param("pattern") String pattern);

    
    @Query("from Issues where title like %:title%")
    List<Issues> findIdByTitleContains(@Param("title") String title);
    
    @Query("select \n" +
            "new com.mytests.spring.jpa.springjpaqueries.repositories.IssueIdAndTitle(issue.id, issue.title) \n" +
            "from Issues as issue where \n" +
            "((lower(issue.author) = :aparam) \n" +
            "   and (issue.id not between 1 and 3) \n" +
            "   and " +
            "(locate('c', issue.title)= 1))")
    List<IssueIdAndTitle> getIdsAndTitlesByAuthor(@Param("aparam") String author);
    
    @Query ("select issue.id, issue.title from Issues as issue")
    List<Object> getIdsAndTitles();
}
