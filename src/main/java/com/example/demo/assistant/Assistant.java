package com.example.demo.assistant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Assistant {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	private String email;
	private String company;
	
	public Assistant() {
		super();
	}
	
	
	public Assistant(long id, String name, String email, String company) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.company = company;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
}
