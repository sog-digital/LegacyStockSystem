package com.sogeti.digital.lss.repository;

import com.sogeti.digital.lss.model.Person;

public interface PersonRepo {
	
	public Person read(String email);
	
	public boolean update(Person person);
	
	public boolean changePassword(Person person);

}
