package com.hibernate.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String airline;
	
	private String flightNumber;
	
	private String origin;
	
	private String destination;
	
	private LocalDate departureTime;
	
	private LocalDate arrivalTime;
	
	@OneToMany(mappedBy = "flight")
	private List<Ticket> tickets;

}
