package com.sogeti.digital.lss.repository;

import com.sogeti.digital.lss.model.Person;

public interface PersonRepoInterface {
	
	public boolean login(String email, String password);
	
	public Person read(int id);
	
	public boolean update(Person person);
	
	public boolean changePassword(Person person);

}
