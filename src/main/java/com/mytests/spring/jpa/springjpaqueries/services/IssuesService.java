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

        System.out.println("========= all issues:");
        for (Issues issues : issuesRepository.findAll()) {
            System.out.println(issues.toString());
        }
    }

    public void displayMediumPriorityIssues(){

        System.out.println("========= medium-priority issues:");
        for (Issues issues : issuesRepository.findByExplicitQuery1()) {
            System.out.println(issues.toString());
        }
    }
    public void displayOpenIssues(){

        System.out.println("========= open issues:");
        for (Issues issues : issuesRepository.findOpenIssues()) {
            System.out.println(issues.toString());
        }
    }
}
