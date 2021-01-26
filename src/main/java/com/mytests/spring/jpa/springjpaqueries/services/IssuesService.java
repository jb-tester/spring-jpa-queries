package com.mytests.spring.jpa.springjpaqueries.services;

import com.mytests.spring.jpa.springjpaqueries.data.Issues;
import com.mytests.spring.jpa.springjpaqueries.repositories.IssuesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IssuesService {

    @Autowired
    private IssuesRepository issuesRepository;

    public void displayAllIssues(){

        System.out.println("=========(default method) all issues:");
        for (Issues issues : issuesRepository.findAll()) {
            System.out.println(issues.toString());
        }
    }

    public void displayMediumPriorityIssues(){

        System.out.println("=========(explicit query) medium-priority issues:");
        for (Issues issues : issuesRepository.findByExplicitQuery1()) {
            System.out.println(issues.toString());
        }
    }
    public void displayLowPriorityIssues(){

        System.out.println("=========(native query) low-priority issues:");
        for (Issues issues : issuesRepository.findByPriorityEnum()) {
            System.out.println(issues.toString());
        }
    }
    public void displayOpenIssues(){

        System.out.println("=========(native query) open issues: ");
        for (Issues issues : issuesRepository.findOpenIssues()) {
            System.out.println(issues.toString());
        }
    }
    public void displayTitlesByKeywords(){

        System.out.println("=========(explicit query) issues that contain the keyword: ");
        for (String title : issuesRepository.findTitlesByKeyword("repo")) {
            System.out.println(title);
        }
    }
    
}
