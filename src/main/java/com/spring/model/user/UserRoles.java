package com.spring.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "userRoles")
@Table(name = "userRoles")
public class UserRoles {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
}
