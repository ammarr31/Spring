package com.springgg.core;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PersonService implements UserService {
	private String name;
	
	@Override
	public void save(String name) {
		this.name = name;
		System.out.println("Saving : " + name);
	}

	@Override
    public void show() {
        System.out.println("Person name: " + name);
    }
	
	@PostConstruct
    public void init() {
        System.out.println("start");
    }
	
	@PreDestroy
    public void destroy() {
        System.out.println("finish");
    }

}
