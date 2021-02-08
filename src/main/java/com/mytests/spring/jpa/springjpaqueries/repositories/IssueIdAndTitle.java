package com.mytests.spring.jpa.springjpaqueries.repositories;

/**
 * *
 * <p>Created by irina on 08.02.2021.</p>
 * <p>Project: spring-jpa-queries</p>
 * *
 */
public class IssueIdAndTitle {
    Long id;
    String title;

    public IssueIdAndTitle(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    @Override
    public String toString() {
        return "IssueIdAndTitle: " +
                "id=" + id +
                ", title='" + title + '\'' +
                ' ';
    }
}
