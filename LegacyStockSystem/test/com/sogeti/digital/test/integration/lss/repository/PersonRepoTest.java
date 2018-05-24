package com.sogeti.digital.test.integration.lss.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sogeti.digital.lss.repository.PersonRepoIml;



public class PersonRepoTest {
	
	protected static PersonRepoIml ps;
	
	@BeforeClass
	public static void setUp()  {
		
		ps = new PersonRepoIml();
	}
	
	@AfterClass
	public static void tearDown() {
		
		ps = null;
	}
	
	@Test	
	public void validLogin() {
		
		assertTrue("login successful", ps.login("sogeti@sogeti.com", "pass"));
	}
	
	@Test	
	public void loginFailureDueToEmail() {

		assertFalse("login failure due to email address", ps.login("sogeti@so.com", "pass"));
	}
	
	@Test	
	public void loginFailureDueToPassword() {

		assertFalse("login failure due to password", ps.login("sogeti@sogeti.com", "pas"));
	}
	
	@Test	
	public void loginFailureDueToEmailAndPassword() {

		assertFalse("login failure due to email address and password", ps.login("sogeti@seti.com", "pas"));
	}

}
