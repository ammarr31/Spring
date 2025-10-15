package com.spring.core;

public class MangerService implements UserService {

	@Override
	public void save(String name) {
		System.out.println("Manger Saved With Name : " + name);
		
	}

	@Override
	public void update(String name) {
		System.out.println("Manger Updated With Name : " + name);
		
	}

}
