package com.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Entity
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 50)
	private String name;
	
	@Min(15)
	@Max(20)
	private Integer age;
	
	@Column(unique = true)
	private String address;

	
	public Teacher() {
		
	}
	
	public Teacher(String name, String password, Integer age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}
	public Teacher(Long id, String name, String password, Integer age, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = password;
		this.age = age;
		this.address = address;
	}

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

	public String getPassword() {
		return address;
	}

	public void setPassword(String password) {
		this.address = password;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student_907 [id=" + id + ", name=" + name + ", password=" + address + ", age=" + age
				+ ", address=" + address + "]";
	}
	
	
}
