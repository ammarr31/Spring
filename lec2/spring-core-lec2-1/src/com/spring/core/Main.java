package com.spring.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		
		MangerService manger = applicationContext.getBean("manger", MangerService.class);
		System.out.println("XML");
		manger.save("ahmed");
		manger.update("ziad");
		PersonService person = applicationContext.getBean("person", PersonService.class);
		person.save("asd");
		person.update("yassin");
		
		AnnotationConfigApplicationContext applicationContextt = new AnnotationConfigApplicationContext(JavaConfig.class);
		MangerService manger1 = applicationContextt.getBean("mangerr", MangerService.class);
		System.out.println("-----------------------------------");
		System.out.println("JAVA");
		manger1.save("Mazen");
		manger1.update("Gazy");
		
		PersonService person1 = applicationContextt.getBean("personn", PersonService.class);
		person1.save("Ben");
		person1.update("max");
	}

}
