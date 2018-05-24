// Working example of JMock it 

package com.sogeti.digital.test.mocking.lss.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;

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
	

	
	
	
}
