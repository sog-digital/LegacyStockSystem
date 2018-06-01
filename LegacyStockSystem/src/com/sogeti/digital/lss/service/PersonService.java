package com.sogeti.digital.lss.service;

import com.sogeti.digital.lss.model.Person;

public interface PersonService {
	
	/** 
	 * This method checks the user credentials on the Legacy Stock Control System
	 * 
	 * @param email 
	 * @param password
	 * @return boolean value
	 */
	public boolean login(String email, String password);

	/**
	 * This method gets the user details from the Legacy Stock Control System
	 * 
	 * @param email
	 * @return Person details
	 */
	public Person read(String email);
	
	/**
	 * This method allows users to change password on to the Legacy Stock Control System
	 * 
	 * @param person
	 * @return boolean value
	 */
	public boolean changePassword(Person person);

}
