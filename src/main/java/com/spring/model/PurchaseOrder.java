package com.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "purchaseOrder")
@Table(name = "purchaseOrder")
public class PurchaseOrder {

	@Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
}
