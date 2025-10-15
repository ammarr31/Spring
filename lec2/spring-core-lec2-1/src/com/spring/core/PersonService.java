package com.spring.core;

public class PersonService implements UserService {

	@Override
	public void save(String name) {
		System.out.println("Person Saved With Name : " + name);
		
	}

	@Override
	public void update(String name) {
		System.out.println("Person Updated With Name : " + name);
		
	}

}