package com.hibernate.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    private String fullName;
    
    private String address;
    
    private String phoneNumber;
    
    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
    
}
