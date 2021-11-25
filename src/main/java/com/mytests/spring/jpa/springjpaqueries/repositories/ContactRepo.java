package com.mytests.spring.jpa.springjpaqueries.repositories;

import com.mytests.spring.jpa.springjpaqueries.data.ContactEntity;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

@RepositoryDefinition(domainClass = ContactEntity.class, idClass = Integer.class )
public interface ContactRepo {

    List<ContactEntity> query1(String lastname);
    List<ContactEntity> query2(String firstname);
    List<ContactEntity> nativeQuery1(String tel);
    List<ContactEntity> nativeQuery2(String mail);
}
