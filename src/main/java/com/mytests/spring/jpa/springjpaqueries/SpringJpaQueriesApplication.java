package com.mytests.spring.jpa.springjpaqueries;

import com.mytests.spring.jpa.springjpaqueries.services.IssuesService;
import com.mytests.spring.jpa.springjpaqueries.services.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJpaQueriesApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringJpaQueriesApplication.class, args);
    }
     @Autowired
    ApplicationContext ctx;
    @Override
    public void run(String... args) throws Exception {
        SampleService sampleService = ctx.getBean(SampleService.class);
        sampleService.displayAll();
        sampleService.displayByColorCriteria();
        IssuesService issuesService = ctx.getBean(IssuesService.class);
        issuesService.displayAllIssues();
        issuesService.displayMediumPriorityIssues();
        issuesService.displayOpenIssues();
        issuesService.displayOpenIssuesOfIrina();
        issuesService.displayLowPriorityIssues();
        issuesService.displayTitlesByKeywords();
        System.out.println("=====================that's all=======");
    }
}
