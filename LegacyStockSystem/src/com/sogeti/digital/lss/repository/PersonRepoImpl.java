package com.sogeti.digital.lss.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import com.sogeti.digital.lss.model.Person;
import com.sogeti.digital.utils.DBUtils;

public class PersonRepoImpl implements PersonRepo {
	
	@Override
	public boolean update(Person person) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changePassword(Person person) {
		
		boolean returnValue = true;
		String updateQuery = "Update stock.person SET password='"+person.getPassword() +"'"
				+ ",lastUpdated='" + LocalDateTime.now().toString() +"' WHERE ID =1";

		try {
				
			DBUtils.runQuery(updateQuery);
		} catch(SQLException sqle) {
			System.out.println("excpetion in method changePassword : " +sqle.getMessage());
			returnValue = false;
		} finally {
			DBUtils.close();
		}
		
		return returnValue;
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
				person.setPassword(rs.getString("password"));
			}
		
		} catch(SQLException sqle) {
			System.out.println("excpetion in method read : " +sqle.getMessage());
		} finally {
			DBUtils.close();
		}
		
	
		return person;
	}
}
