package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import jakarta.validation.constraints.Max;

@Entity
public class Player {
	public Player() {}
	public Player(Long id, String name, @Max(10) Integer age, Boolean status) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Player [id= " + id + ", name= " + name + ", age= " + age + ", status= " + status + "]";
	}
	@Id
	private Long id;
	
	@Column(nullable = true)
	private String name;
	
	@Max(10)
	private Integer age;
	
	private Boolean status;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	
}
