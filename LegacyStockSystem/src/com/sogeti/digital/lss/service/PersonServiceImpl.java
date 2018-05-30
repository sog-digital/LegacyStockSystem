package com.sogeti.digital.lss.service;

import com.sogeti.digital.lss.model.Person;
import com.sogeti.digital.lss.repository.PersonRepoImpl;
import com.sogeti.digital.lss.repository.PersonRepo;

public class PersonServiceImpl implements PersonService {
	
	PersonRepo personRepo = new PersonRepoImpl();
	
	
	@Override
	public boolean login(String email, String password) {
		
		Person p = personRepo.read(email);
		
		if (p != null && !p.equals("null") && password.equals(p.getPassword())) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean update(Person person) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changePassword(Person person) {
		
		return personRepo.changePassword(person);
	}

	@Override
	public Person read(String email) {
		// TODO Auto-generated method stub
		return personRepo.read(email);
	}

}
