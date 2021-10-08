package com.mytests.spring.jpa.springjpaqueries.repositories;

import com.mytests.spring.jpa.springjpaqueries.data.Issues;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IssuesRepository extends CrudRepository<Issues,Long> {

    //language=JPAQL
    String Q1 = "select issue.id, issue.title from Issues as issue";

    List<Issues> findAll();
    
    // Named queries:
    // the Issues.findByPriorityEnum query
    List<Issues> findByPriorityEnum();
    // the Issues.findOpenIssues query
    List<Issues> findOpenIssues();
    // the Issues.useConcatenation query
    List<Issues> useConcatenation();
    // The Issues.useParameters query. Not checked for parameters!
    List<Issues> useParameters(String author);
    // query from jpa-named-queries.properties: 
    List<Issues> namedQueryFromProperties(String author, Issues.StateEnum state);
    
    
    // Explicit queries:
    @Query("select issue from Issues issue where issue.priority = com.mytests.spring.jpa.springjpaqueries.utils.PriorityEnum.Medium")
    List<Issues> findByExplicitQuery1();
    
    @Query("select issue.title from Issues issue where issue.title like %:pattern% or issue.description like " +
            "%:pattern%")
    List<String> findTitlesByKeyword(@Param("pattern") String pattern);

    
    @Query("from Issues where title like %:title% and author in ('irina','ira')")
    List<Issues> findIdByTitleContains(@Param("title") String title);
    
    @Query("select new com.mytests.spring.jpa.springjpaqueries.repositories.IssueIdAndTitle(issue.id, issue.title) " +
            "from Issues as issue where " +
            "((lower(issue.author) = :aparam) " +
            "   and (issue.id not between 1 and 3) " +
            "   and " +
            "(locate('c', issue.title)= 1))")
    List<IssueIdAndTitle> getIdsAndTitlesByAuthor(@Param("aparam") String author);

    // enums:
    // https://youtrack.jetbrains.com/issue/IDEA-160992
    @Query(value = "select * from jbtests.issues where state = :state", nativeQuery = true)
    List<Issues> findByState(@Param("state") Issues.StateEnum state);
    @Query("SELECT o FROM Issues o WHERE o.priority = 'High' OR o.priority = com.mytests.spring.jpa.springjpaqueries.utils.PriorityEnum.Medium")
    List<Issues> findByPriority();
    @Query("SELECT o FROM Issues o WHERE o.priority IN ('High', 'Medium')") // https://youtrack.jetbrains.com/issue/IDEA-244155
    List<Issues> findByPriorities();

     @Query("SELECT o FROM Issues o WHERE o.priority IN (com.mytests.spring.jpa.springjpaqueries.utils.PriorityEnum.High, com.mytests.spring.jpa.springjpaqueries.utils.PriorityEnum.Medium)") // https://youtrack.jetbrains.com/issue/IDEA-80076
     List<Issues> findByPrioritiesAsTypes();


 // use constants:
    @Query (Q1)
    List<Object> getIdsAndTitles();

    @Query ("select issue from Issues issue where issue.id between "+MIN+" and "+MAX)
    List<Issues> getsmth();
    
    String MIN = "2";
    String MAX = "5";
    String STR1 = "table";
    String STR2 = "irina";
    
    @Query (value = "select * from jbtests.issues where (id between 2 and 5) " +
            "and lower(author) = lower('"+STR2+"') " +
            "and lower(title) like lower('"+STR1+"') ", 
            nativeQuery = true)
    List<Issues> getSmthNative();
}
