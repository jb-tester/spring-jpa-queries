package com.mytests.spring.jpa.springjpaqueries.data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * *
 * <p>Created by irina on 06.04.2022.</p>
 * <p>Project: spring-jpa-queries</p>
 * *
 */
@Entity
public class Delivery {
    @Id @GeneratedValue
    private Long id;

    private Date orderDate;
    private Date deliveryDate;
    private String address;

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
    
}
