package com.sogeti.digital.lss.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

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
	/**
	 * 
	 */
	@Override
	public Person read(int id) {
		// TODO Auto-generated method stub
		return null;
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
	
	

}
