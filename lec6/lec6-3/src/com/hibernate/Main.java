package com.hibernate;

import java.util.Arrays;

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

        Friend friend1 = new Friend("ahmed");
        Friend friend2 = new Friend("yazn");

        User user = new User("omar", 25);

        UserDetails userDetails = new UserDetails("cairo", "01030130");
        userDetails.setUser(user);
        user.setUserDetails(userDetails);

        user.setFriends(Arrays.asList(friend1, friend2));

        friend1.setUsers(Arrays.asList(user));
        friend2.setUsers(Arrays.asList(user));

        Post post1 = new Post("first post", "my first post!");
        Post post2 = new Post("second post", "second post!");
        user.setPosts(Arrays.asList(post1, post2));

        post1.setUser(user);
        post2.setUser(user);

        session.save(user);

        transaction.commit();
        session.close();
        factory.close();

    }
}
