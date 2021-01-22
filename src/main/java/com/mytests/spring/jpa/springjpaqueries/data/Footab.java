package com.mytests.spring.jpa.springjpaqueries.data;

import javax.persistence.*;
import java.util.Objects;

/**
 * *
 * <p>Created by irina on 22.01.2021.</p>
 * <p>Project: spring-jpa-queries</p>
 * *
 */
@Entity
@Table(name = "footab", schema = "ip_tests")
public class Footab {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private Integer age;
    private Byte enabled;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

   

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "enabled")
    public Byte getEnabled() {
        return enabled;
    }

    public void setEnabled(Byte enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Footab footab = (Footab) o;
        return Objects.equals(id, footab.id) && Objects.equals(username, footab.username) && Objects.equals(age,
                footab.age) && Objects.equals(enabled, footab.enabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, age, enabled, id);
    }
}
