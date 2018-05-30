package com.digital.tests.lss.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.sogeti.digital.lss.model.Person;
import com.sogeti.digital.lss.repository.PersonRepoImpl;
import com.sogeti.digital.lss.service.PersonServiceImpl;

import mockit.Expectations;
import mockit.Mocked;
import mockit.Tested;
import mockit.integration.junit4.JMockit;


@RunWith(JMockit.class)
public class PersonServiceTest {
	
	@Mocked
	private PersonRepoImpl pr;
	
	@Tested
	private PersonServiceImpl psi;
	
	
	@Test	
	public void validLogin() {
		
		Person personReturned = new Person();
		personReturned.setId(1);
		personReturned.setFirstName("sogeti");
		personReturned.setLastName("ireland");
		personReturned.setDob("01-01-1967");
		personReturned.setEmail("sogeti@sogeti.com");
		personReturned.setPassword("pass");
		
		new Expectations() {
			{	
				pr.read("sogeti@sogeti.com");
				result = personReturned;
			}
		};
		
		assertTrue("login not successful", psi.login("sogeti@sogeti.com", "pass"));
	}
	
	@Test	
	public void loginFailureDueToEmail() {
		
		Person personReturned = null;
		
		new Expectations() {
			{
				pr.read("sogeti@soi.com");
				result = personReturned;				
			}
		};

		assertFalse("login failure due to email address", psi.login("sogeti@soi.com", "pass"));
	}
	
	@Test	
	public void loginFailureDueToPassword() {
		
		Person personReturned = new Person();
		personReturned.setId(1);
		personReturned.setFirstName("sogeti");
		personReturned.setLastName("ireland");
		personReturned.setDob("01-01-1967");
		personReturned.setEmail("sogeti@sogeti.com");
		personReturned.setPassword("pass");
		
		new Expectations() {
			{
				pr.read("sogeti@sogeti.com");
				result = personReturned;				
			}
		};

		assertFalse("login failure due to password", psi.login("sogeti@sogeti.com", "wrongpass"));
	}

	@Test	
	public void loginFailureDueToEmailAndPassword() {
		
		Person personReturned = null;
		new Expectations() {
			{
				pr.read("sogeti@sti.com");
				result = personReturned;				
			}
		};

		assertFalse("login failure due to email address and password", psi.login("sogeti@sti.com", "wrongpass"));
	}

	@Test
	public void checkPersonDetails() {
		
		Person personExpected = new Person();
		personExpected.setId(1);
		personExpected.setFirstName("sogeti");
		personExpected.setLastName("ireland");
		personExpected.setDob("01-01-1967");
		personExpected.setEmail("sogeti@sogeti.com");
		
		final Person personReturned = new Person();
		personReturned.setId(1);
		personReturned.setFirstName("sogeti");
		personReturned.setLastName("ireland");
		personReturned.setDob("01-01-1967");
		personReturned.setEmail("sogeti@sogeti.com");
		
		new Expectations() {
			{
				pr.read("sogeti@sogeti.com");
				result = personReturned;				
			}
		};
		
		Person person = psi.read("sogeti@sogeti.com");
		
		assertEquals(personExpected.getFirstName(), person.getFirstName(),"matches the first name");
		assertEquals(personExpected.getLastName(), person.getLastName(),"matches the last name");
		assertEquals(personExpected.getDob(), person.getDob(),"matches the dob");
		assertEquals(personExpected.getEmail(), person.getEmail(),"matches the email");
		
	}
	
	@Test	
	public void changePasswordSuccess() {
		
		Person person = new Person();
		person.setId(1);
		person.setPassword("newpass");
		
		new Expectations() {
			{
				pr.changePassword(person);
				result = true;				
			}
		};

		assertTrue("change password Success", psi.changePassword(person));
	}
	
	@Test	
	public void changePasswordFailure() {
		
		Person person = new Person();
		person.setId(1);
		person.setPassword("newpass");
		
		new Expectations() {
			{
				pr.changePassword(person);
				result = false;				
			}
		};

		assertFalse("change password failure", psi.changePassword(person));
	}
	
}
