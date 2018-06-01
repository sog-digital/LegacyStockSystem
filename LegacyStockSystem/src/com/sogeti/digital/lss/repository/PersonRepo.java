package com.sogeti.digital.lss.repository;

import com.sogeti.digital.lss.model.Person;

public interface PersonRepo {
	
	/**
	 * This method gets the user details from the Legacy Stock Control System
	 * 
	 * @param email
	 * @return
	 */
	public Person read(String email);
	
	/**
	 * This method allows users to change password on to the Legacy Stock Control System
	 * 
	 * @param person
	 * @return
	 */
	public boolean changePassword(Person person);

}
