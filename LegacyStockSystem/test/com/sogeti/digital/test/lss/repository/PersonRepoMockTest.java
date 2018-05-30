// Working example of JMock it 

package com.sogeti.digital.test.mocking.lss.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.sogeti.digital.lss.model.Person;
import com.sogeti.digital.lss.repository.PersonRepoIml;

import mockit.Expectations;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;


@RunWith(JMockit.class)
public class PersonRepoMockTest {
	
	@Mocked
	private PersonRepoIml ps;
	
	
	@Test	
	public void validLogin() {
		
		new Expectations() {
			{
				ps.login("sogeti@sogeti.com", "pass");
				result = true;				
			}
		};
		
		assertTrue("login successful", ps.login("sogeti@sogeti.com", "pass"));
	}
	
	@Test	
	public void loginFailureDueToEmail() {
		
		new Expectations() {
			{
				ps.login("sogeti@soi.com", "pass");
				result = false;				
			}
		};

		assertFalse("login failure due to email address", ps.login("sogeti@soi.com", "pass"));
	}
	
	@Test	
	public void loginFailureDueToPassword() {
		
		new Expectations() {
			{
				ps.login("sogeti@sogeti.com", "wrongpass");
				result = false;				
			}
		};

		assertFalse("login failure due to password", ps.login("sogeti@sogeti.com", "wrongpass"));
	}

	@Test	
	public void loginFailureDueToEmailAndPassword() {
		
		new Expectations() {
			{
				ps.login("sogeti@sti.com", "wrongpass");
				result = false;				
			}
		};

		assertFalse("login failure due to email address and password", ps.login("sogeti@sti.com", "wrongpass"));
	}

	@Test
	public void personDetailsAreCorrect() {
		
		Person personExpected = new Person();
		personExpected.setId(1);
		personExpected.setFirstName("sogeti");
		personExpected.setLastName("ireland");
		personExpected.setDob("01-01-1967");
		personExpected.setEmail("sogeti@sogeti.com");
		
		Person personReturned = new Person();
		personReturned.setId(1);
		personReturned.setFirstName("sogeti");
		personReturned.setLastName("ireland");
		personReturned.setDob("01-01-1967");
		personReturned.setEmail("sogeti@sogeti.com");
		
		new Expectations() {
			{
				ps.read("sogeti@sogeti.com");
				result = personReturned;				
			}
		};
		
		ps.read("sogeti@sogeti.com");
		
		assertEquals(personExpected.getFirstName(), personReturned.getFirstName(),"matches the first name");
		assertEquals(personExpected.getLastName(), personReturned.getLastName(),"matches the last name");
		assertEquals(personExpected.getDob(), personReturned.getDob(),"matches the dob");
		assertEquals(personExpected.getEmail(), personReturned.getEmail(),"matches the email");
		
	}
	
	@Test
	public void personDetailsAreNotCorrect() {
		
		Person personExpected = new Person();
		personExpected.setId(1);
		personExpected.setFirstName("sogeti");
		personExpected.setLastName("ireland");
		personExpected.setDob("01-01-1967");
		personExpected.setEmail("sogeti@sogeti.com");
		
		Person personReturned = new Person();
		personReturned.setId(1);
		personReturned.setFirstName("sogeti");
		personReturned.setLastName("ireland");
		personReturned.setDob("01-01-1967");
		personReturned.setEmail("sogeti@soti.com");
		
		new Expectations() {
			{
				ps.read("sogeti@sogeti.com");
				result = personReturned;				
			}
		};
		
		ps.read("sogeti@sogeti.com");
		
		assertEquals(personExpected.getFirstName(), personReturned.getFirstName(),"matches the first name");
		assertEquals(personExpected.getLastName(), personReturned.getLastName(),"matches the last name");
		assertEquals(personExpected.getDob(), personReturned.getDob(),"matches the dob");
		assertNotEquals(personExpected.getEmail(), personReturned.getEmail(),"Does not matches the email");
		
	}
}
