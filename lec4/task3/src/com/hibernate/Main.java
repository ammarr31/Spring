package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.Passport;
import com.hibernate.model.Student;

public class Main {

	public static void main(String[] args) {
		Configuration configuration = new Configuration()
				.addAnnotatedClass(Student.class)
				.addAnnotatedClass(Passport.class)
				.configure("hibernate.cfg.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		

		Transaction transaction = session.beginTransaction();

		
		transaction.commit();

	
	}

}

