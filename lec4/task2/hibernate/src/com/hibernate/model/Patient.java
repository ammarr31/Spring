package com.hibernate.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    private String name;
    private String typeOfDisease;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private Doctor doctor;
    
    @ManyToMany
    @JoinTable(
    	    name = "Hospital_Patient",
    	    joinColumns = @JoinColumn(name = "patient_id"),
    	    inverseJoinColumns = @JoinColumn(name = "hospital_id")
    	)
    private List<Hospital> hospitals;

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

	public String getTypeOfDisease() {
		return typeOfDisease;
	}

	public void setTypeOfDisease(String typeOfDisease) {
		this.typeOfDisease = typeOfDisease;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public List<Hospital> getHospitals() {
		return hospitals;
	}

	public void setHospitals(List<Hospital> hospitals) {
		this.hospitals = hospitals;
	}
}
