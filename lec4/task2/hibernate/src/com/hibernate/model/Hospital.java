package com.hibernate.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Hospital {
	 
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

	    private String name;
	    
	    private int numberOfDoctors;
	    
	    private int numberOfPatient;
	    
	    @OneToMany(mappedBy = "hospital")
	    private List<Doctor> doctors;
	    
	    @ManyToMany(mappedBy = "hospitals")
	    private List<Patient> patients;

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

		public int getNumberOfDoctors() {
			return numberOfDoctors;
		}

		public void setNumberOfDoctors(int numberOfDoctors) {
			this.numberOfDoctors = numberOfDoctors;
		}

		public int getNumberOfPatient() {
			return numberOfPatient;
		}

		public void setNumberOfPatient(int numberOfPatient) {
			this.numberOfPatient = numberOfPatient;
		}

		public List<Doctor> getDoctors() {
			return doctors;
		}

		public void setDoctors(List<Doctor> doctors) {
			this.doctors = doctors;
		}

		public List<Patient> getPatients() {
			return patients;
		}

		public void setPatients(List<Patient> patients) {
			this.patients = patients;
		}

		

}
