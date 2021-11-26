package com.mytests.spring.jpa.springjpaqueries.data;

import javax.persistence.*;

@Entity
@Table(name = "contact", schema = "jbtests")
@NamedQueries(
        {@NamedQuery(name = "ContactEntity.query1",
        query = "select c from ContactEntity c where c.lastname = ?1"),
        @NamedQuery(name = "ContactEntity.query2",
        query = "select c from ContactEntity c where c.firstname = ?1")})
@NamedNativeQueries(
        {@NamedNativeQuery(name = "ContactEntity.nativeQuery1",
                query = "select * from contact where telephone = :telephone"),
        @NamedNativeQuery(name = "ContactEntity.nativeQuery2",
        query = "select * from contact where email = :email")})
public class ContactEntity {
    @Id
    private Integer id;
    @Basic
    private String firstname;
    @Basic
    private String lastname;
    @Basic
    private String telephone;
    @Basic
    private String email;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return firstname;
    }

    public void setName(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return lastname;
    }

    public void setSurname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return telephone;
    }

    public void setPhone(String telephone) {
        this.telephone = telephone;
    }

    public String getMailAddr() {
        return email;
    }

    public void setMailAddr(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ContactEntity{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
