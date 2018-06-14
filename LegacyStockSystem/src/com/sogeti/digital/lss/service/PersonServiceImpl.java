package com.sogeti.digital.lss.service;

import com.sogeti.digital.lss.model.Person;
import com.sogeti.digital.lss.repository.PersonRepoImpl;
import com.sogeti.digital.utils.PasswordUtils;
import com.sogeti.digital.lss.repository.PersonRepo;

public class PersonServiceImpl implements PersonService {
	
	PersonRepo personRepo = new PersonRepoImpl();

	@Override
	public boolean changePassword(Person person) {
		
		return personRepo.changePassword(person);
	}

	@Override
	public Person read(String email) {
		// TODO Auto-generated method stub
		return personRepo.read(email);
	}

	@Override
	public boolean secureLogin(String email, String encryptedPassword) {
	
		Person p = personRepo.read(email);

		if (p != null && !p.equals("null") && encryptedPassword != null &&
				!encryptedPassword.equals("null") && p.getPassword() != null 
				&& !p.getPassword().equals("null") && encryptedPassword.length() > 0 
				&& p.getPassword().length() > 0) {
			
			String entertedPassword = PasswordUtils.decrypt(encryptedPassword);
			
			String userPasswordInDB = PasswordUtils.decrypt(p.getPassword());
			
			if( entertedPassword != null && userPasswordInDB != null 
					&& entertedPassword.length() > 0 && userPasswordInDB.length() > 0
					&& entertedPassword.equals(userPasswordInDB)   ) {
				
				return true;
			}  else {
				return false;
			}

		}
		else {
			return false;
		}
	}

}
