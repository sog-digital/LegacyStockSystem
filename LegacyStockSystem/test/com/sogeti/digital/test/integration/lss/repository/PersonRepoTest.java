package com.sogeti.digital.test.integration.lss.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sogeti.digital.lss.model.Person;
import com.sogeti.digital.lss.repository.PersonRepoIml;



public class PersonRepoTest {
	
	protected static PersonRepoIml ps;
	protected static Person personExpected;
	
	@BeforeClass
	public static void setUp()  {
		
		ps = new PersonRepoIml();
		personExpected = new Person();
		personExpected.setId(1);
		personExpected.setFirstName("sogeti");
		personExpected.setLastName("ireland");
		personExpected.setDob("01-01-1967");
		personExpected.setEmail("sogeti@sogeti.com");
		
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
	
	@Test
	public void personDetailsAreCorrect() {
		
		Person person = ps.read("sogeti@sogeti.com");
		//assertEquals("Found the person details for " + personExpected.getEmail() +"", personExpected, person);
		assertEquals(personExpected.getFirstName(), person.getFirstName(),"matches the first name");
		assertEquals(personExpected.getLastName(), person.getLastName(),"matches the last name");
		assertEquals(personExpected.getDob(), person.getDob(),"matches the dob");
		assertEquals(personExpected.getEmail(), person.getEmail(),"matches the email");
	}
	
	

}
