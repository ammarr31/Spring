package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.model.Player;
import com.hibernate.model.Student_907;

public class Main {

	public static void main(String[] args) {
		Configuration configuration = new Configuration()
				.addAnnotatedClass(Player.class)
				.configure("hibernate.cfg.xml");
		
		SessionFactory factory = configuration.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		

		Transaction transaction = session.beginTransaction();

		Player player1 = new Player(1L,"Messi",35, true);
		Player player2 = new Player(2L,"VINI",26, false);
		
		session.save(player1);
		session.save(player2);
		System.out.println(" ");
		System.out.println("------- CREATED PLAYERS --------");
		System.out.println(player1.toString());
		System.out.println(player2.toString());
		player1.setAge(36);
		session.update(player1);
		System.out.println(" ");
		System.out.println("------- UPDATED PLAYER --------");
		System.out.println(player1.toString());
		
		String deletedPlayer = player2.getName();
		
		session.delete(player2);
		System.out.println(" ");
		System.out.println("-------> PLAYER "+ deletedPlayer +" Deleted <--------");
		
		System.out.println(" ");
		System.out.println("------- GET PLAYER With ID 1 --------");
		Player getPlayer = session.get(Player.class, 1L);
		System.out.println(getPlayer.toString());
		System.out.println(" ");
		transaction.commit();

	
	}

}

