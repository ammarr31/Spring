package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.Doctor;
import com.hibernate.model.DoctorDetails;
import com.hibernate.model.Hospital;
import com.hibernate.model.Patient;
public class Main {

	public static void main(String[] args) {
		Configuration configuration = new Configuration()
				.addAnnotatedClass(Doctor.class)
				.addAnnotatedClass(DoctorDetails.class)
				.addAnnotatedClass(Hospital.class)
				.addAnnotatedClass(Patient.class)
				.configure("hibernate.cfg.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		

		Transaction transaction = session.beginTransaction();

		
		transaction.commit();

	
	}

}

