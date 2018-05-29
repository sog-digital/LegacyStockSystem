package com.sogeti.digital.lss.service;

import com.sogeti.digital.lss.model.Person;
import com.sogeti.digital.lss.repository.PersonRepoIml;
import com.sogeti.digital.lss.repository.PersonRepoInterface;

public class PersonServiceImpl implements PersonServiceInterface {
	
	PersonRepoInterface personService = new PersonRepoIml();
	

	@Override
	public boolean login(String email, String password) {
		// TODO Auto-generated method stub
		return personService.login(email, password);
	}

	@Override
	public boolean update(Person person) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changePassword(Person person) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Person read(String email) {
		// TODO Auto-generated method stub
		return personService.read(email);
	}

}
