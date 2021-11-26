package com.mytests.spring.jpa.springjpaqueries.repositories;

import com.mytests.spring.jpa.springjpaqueries.data.ContactEntity;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;

import java.util.List;

@RepositoryDefinition(domainClass = ContactEntity.class, idClass = Integer.class )
public interface ContactRepo {

    List<ContactEntity> query1(String lastname);
    List<ContactEntity> query2(String firstname);
    List<ContactEntity> nativeQuery1(@Param("telephone") String tel);
    List<ContactEntity> nativeQuery2(@Param("email") String mail);
}
