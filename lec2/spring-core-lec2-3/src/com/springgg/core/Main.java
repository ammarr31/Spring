package com.springgg.core;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// i have a problem in console --> repeating start at first in xml section :(
		System.out.println("XML");
		ClassPathXmlApplicationContext applicationContext = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		UserService person1 = applicationContext.getBean("personService", UserService.class);
		person1.save("Maisson");
		person1.show();
		applicationContext.close();
		
		System.out.println(" ");
		System.out.println("JAVA");
		AnnotationConfigApplicationContext applicationContextt = new AnnotationConfigApplicationContext(JavaConfig.class);
		UserService person2 = applicationContextt.getBean("personn", UserService.class);
		person2.save("Masry");
		person2.show();
		
		applicationContextt.close();
		
		
	}

}
