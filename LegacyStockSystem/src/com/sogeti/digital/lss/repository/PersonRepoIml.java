package com.sogeti.digital.lss.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.sogeti.digital.lss.model.Person;
import com.sogeti.digital.utils.DBUtils;

public class PersonRepoIml implements PersonRepoInterface {
	
	/**
	 * 
	 * @param email
	 * @param password
	 * @return
	 */
	@Override
	public boolean login(String email, String password) {
		
		boolean returnValue = false;
		
		String findPersonQuery = "Select * from stock.person where email='"+ email +"' and password ='" +password +"'";
		try {
		ResultSet rs = DBUtils.getResultSet(findPersonQuery);
		
			if(rs != null && rs.next()) {
			
				if(rs.getString("email").equalsIgnoreCase(email) && rs.getString("password").equals(password) ) {
				
					returnValue = true;
				}
			}
		
		} catch(SQLException sqle) {
			System.out.println("excpetion in method login : " +sqle.getMessage());
		}
		
		return returnValue;
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
		
		Person person = null;
		
		String findPersonQuery = "Select * from stock.person where email='"+ email +"'";
		try {
		ResultSet rs = DBUtils.getResultSet(findPersonQuery);
		
			if(rs != null && rs.next()) {
			
				person = new Person();
				person.setFirstName(rs.getString("firstname"));
				person.setLastName(rs.getString("lastname"));
				person.setDob(rs.getString("dob"));
				person.setEmail(rs.getString("email"));
				person.setId(rs.getInt("ID"));
				
			}
		
		} catch(SQLException sqle) {
			System.out.println("excpetion in method login : " +sqle.getMessage());
		}
		
		
		// TODO Auto-generated method stub
		return person;
	}
}
