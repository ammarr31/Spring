package com.springg.core;

public class PersonService implements UserService {

	@Override
	public void save(String name) {
		System.out.println("Person Saved With Name : " + name);
		
	}


}