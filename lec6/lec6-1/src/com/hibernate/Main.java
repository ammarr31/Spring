package com.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.Friend;
import com.hibernate.model.Post;
import com.hibernate.model.User;
import com.hibernate.model.UserDetails;
public class Main {

	public static void main(String[] args) {
		Configuration configuration = new Configuration()
				.addAnnotatedClass(User.class)
				.addAnnotatedClass(UserDetails.class)
				.addAnnotatedClass(Post.class)
				.addAnnotatedClass(Friend.class)
				.configure("hibernate.cfg.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		

		Transaction transaction = session.beginTransaction();
		
		
		transaction.commit();

	}

}

