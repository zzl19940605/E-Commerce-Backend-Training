package com.mercury.SpringBootRestDemo.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "MSI_USER_PROFILE")
public class Profile implements GrantedAuthority {

	@Id
	private int id;
	
	@Column
	private String type;

	public Profile() {
		super();
	}
	
	public Profile(int id) {
		super();
		this.id = id;
	}

	public Profile(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", type=" + type + "]";
	}

	@Override
	public String getAuthority() {
		return type;
	}
}
