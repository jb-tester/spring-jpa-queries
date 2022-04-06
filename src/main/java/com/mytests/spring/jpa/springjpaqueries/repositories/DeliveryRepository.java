package com.mytests.spring.jpa.springjpaqueries.repositories;

import com.mytests.spring.jpa.springjpaqueries.data.Delivery;
import com.mytests.spring.jpa.springjpaqueries.data.Issues;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * *
 * <p>Created by irina on 06.04.2022.</p>
 * <p>Project: spring-jpa-queries</p>
 * *
 */
public interface DeliveryRepository extends CrudRepository<Delivery, Long> {
    @Query("select d from Delivery d where d.orderDate < current_timestamp() + :timeout")
    List<Delivery> test1(@Param("timeout") int timeout);

    @Query("select d from Delivery d where d.deliveryDate < current_time()  ")
    List<Delivery> test2(@Param("timeout") int timeout);
}
