package com.alphacode.handson.web.apis.v1.admin.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADMINS")
public class Admin {

	@Id
	private String id;
}
