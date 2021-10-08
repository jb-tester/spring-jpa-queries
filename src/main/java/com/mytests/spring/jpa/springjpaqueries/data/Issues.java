package com.mytests.spring.jpa.springjpaqueries.data;

import com.mytests.spring.jpa.springjpaqueries.utils.PriorityEnum;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "issues", schema = "jbtests")
@NamedQueries({
        @NamedQuery(name="Issues.useConcatenation",
                query = "select i from Issues i " +
                        "where i.title like '%" + Issues.PATTERN + "%' and i.author in (" + Issues.AUTHORS + ")"),
        @NamedQuery(name="Issues.findByPriorityEnum",
                query = "select i from Issues i where i.priority = com.mytests.spring.jpa.springjpaqueries.utils.PriorityEnum.Low"),
        @NamedQuery(name = "Issues.findOpenIssues",
                query = "select issue from Issues issue where issue.state=com.mytests.spring.jpa.springjpaqueries.data.Issues$StateEnum.Open"), // https://youtrack.jetbrains.com/issue/IDEA-232989
        @NamedQuery(name = "Issues.useParameters", query = "select issue from Issues issue where issue.author = ?1")
        
})
public class Issues {
    public static final String PATTERN = "table";
    public static final String AUTHORS = "'irina','ira'";
    @Id
    @GeneratedValue
    
    private Long id;
    private String title;
    private String author;
    private String description;
    private PriorityEnum priority;
    private StateEnum state;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "priority")
    @Enumerated(EnumType.STRING)
    public PriorityEnum getPriority() {
        return priority;
    }

    public void setPriority(PriorityEnum priority) {
        this.priority = priority;
    }

    @Basic
    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    public StateEnum getState() {
        return state;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Issues issues = (Issues) o;
        return Objects.equals(id, issues.id) && Objects.equals(title, issues.title) && Objects.equals(author, issues.author) && Objects.equals(description, issues.description) && priority == issues.priority && state == issues.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author, description, priority, state);
    }

    @Override
    public String toString() {
        return "Issues{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", priority=" + priority.name() +
                ", state=" + state.name() +
                '}';
    }

    public enum StateEnum {
        Open,Closed
    }
}
