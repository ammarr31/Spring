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

		Friend friend1 = new Friend("Ahmed");
		Friend friend2 = new Friend("Sara");
		session.save(friend1);
		session.save(friend2);

		List<Friend> friends = new ArrayList<>();
		friends.add(friend1);
		friends.add(friend2);

		User user = new User("Omar", 25);
		user.setFriends(friends); 

		UserDetails userDetails = new UserDetails("Cairo, Egypt", "01012345678");
		userDetails.setUser(user);
		user.setUserDetails(userDetails);

		session.save(user);
		session.save(userDetails);

		Post post1 = new Post("first post", "my first!");
		post1.setUser(user);
		session.save(post1);

		Post post2 = new Post("second post", "second post!");
		post2.setUser(user);
		session.save(post2);

		transaction.commit();

		session.close();
		factory.close();
	}
}
