package com.spring.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "roles")
@Table(name = "roles")
public class Roles {
	@Id
	@GeneratedValue
	@Column(name = "roleId")
	private int roleId;
	@Column(name = "roleName")
	private String roleName;
	
}
