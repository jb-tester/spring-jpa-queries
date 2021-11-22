package com.mytests.spring.jpa.springjpaqueries;

import com.mytests.spring.jpa.springjpaqueries.services.IssuesService;
import com.mytests.spring.jpa.springjpaqueries.services.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJpaQueriesApplication implements CommandLineRunner {

    @Autowired
    ApplicationContext ctx;

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaQueriesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SampleService sampleService = ctx.getBean(SampleService.class);
        sampleService.displayAll();
        sampleService.displayByColorCriteria();
        //sampleService.findAndUpdateAllSamplesInList();
        IssuesService issuesService = ctx.getBean(IssuesService.class);
        issuesService.displayAllIssues();
        issuesService.displayMediumPriorityIssues();
        issuesService.displayOpenIssues();
        issuesService.displayOpenIssuesOfIrina();
        issuesService.displayLowPriorityIssues();
        issuesService.displayTitlesByKeywords();
        issuesService.displayIssuesWithTitleContainingPattern();
        System.out.println("=====================that's all=======");
    }
}
