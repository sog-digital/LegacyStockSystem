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
import com.sogeti.digital.utils.PasswordUtils;

import mockit.Expectations;
import mockit.Mocked;
import mockit.Tested;
import mockit.integration.junit4.JMockit;


@RunWith(JMockit.class)
public class PersonServiceTest {
	
	@Mocked
	private PersonRepoImpl pr;
	
	@Mocked 
	private PasswordUtils passUtils;
	
	@Tested
	private PersonServiceImpl psi;

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
	
	
	@Test	
	public void validSecureLogin() {
		
		Person personReturned = new Person();
		personReturned.setEmail("sogeti@sogeti.com");
		personReturned.setPassword("d3EZNGOxjg1BPkAM94UYOA==");
		
		new Expectations() {
			{	
				pr.read("sogeti@sogeti.com");
				result = personReturned;
				PasswordUtils.decrypt("d3EZNGOxjg1BPkAM94UYOA==");
				result = "pass";

			}
		};
		
		assertTrue("secure login successful", psi.secureLogin("sogeti@sogeti.com", "d3EZNGOxjg1BPkAM94UYOA=="));
	}
	
	@Test	
	public void secureLoginFailureDueToWrongPassword() {
		
		Person personReturned = new Person();
		personReturned.setEmail("sogeti@sogeti.com");
		personReturned.setPassword("d3EZNGOxjg1BPkAM94UYOA==");
		
		new Expectations() {
			{	
				pr.read("sogeti@sogeti.com");
				result = personReturned;
				PasswordUtils.decrypt("d3EZNGOxjg1BPkAMA==");
				result = "wpass";
				PasswordUtils.decrypt(personReturned.getPassword());
				result = "pass";
				

			}
		};
		
		assertFalse("secure login failed due to wrong password", psi.secureLogin("sogeti@sogeti.com", "d3EZNGOxjg1BPkAMA=="));
	}
	
	@Test	
	public void secureLoginFailureDueToWrongEmail() {
		
		new Expectations() {
			{	
				pr.read("sogeti@soi.com");
				result = null;
	
			}
		};
		
		assertFalse("secure login failed due to wrong email", psi.secureLogin("sogeti@soi.com", "d3EZNGOxjg1BPkAM94UYOA=="));
	}
	
	@Test	
	public void secureLoginFailureDueToWrongEmailAndPassword() {
		
		new Expectations() {
			{	
				pr.read("sogeti@sogi.com");
				result = null;
				}
		};
		
		assertFalse("secure login failed due to wrong email and password", psi.secureLogin("sogeti@sogi.com", "d3EZNGMA=="));
	}
	
}
