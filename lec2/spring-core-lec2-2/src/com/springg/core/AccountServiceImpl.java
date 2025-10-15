package com.springg.core;

public class AccountServiceImpl implements UserService  {
	
	private PersonService personService;
	
	public AccountServiceImpl(PersonService personService) {
        this.personService = personService;
    }
	
	@Override
	public void save(String name) {
		
		personService.save(name);
		
	}

}
