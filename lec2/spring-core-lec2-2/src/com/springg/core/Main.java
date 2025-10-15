package com.springg.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		System.out.println("XML");
		UserService person1 = applicationContext.getBean("accountServiceImpl", UserService.class);
		person1.save("Maisson");
		
		AnnotationConfigApplicationContext applicationContextt = new AnnotationConfigApplicationContext(JavaConfig.class);
		System.out.println("JAVA");
		UserService person2 = applicationContextt.getBean("impl", UserService.class);
		person2.save("Masry");
	}

}
