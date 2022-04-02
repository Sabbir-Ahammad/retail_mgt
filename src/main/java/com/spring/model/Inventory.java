package com.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "inventory")
@Table(name = "inventory")
public class Inventory {

	@Id
    @GeneratedValue
    @Column(name = "id")
    private int id;
}
