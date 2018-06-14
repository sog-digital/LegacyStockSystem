/**
 * 
 */
package com.sogeti.digital.test.lss.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.sogeti.digital.utils.PasswordUtils;

/**
 * @author NIRGOYAL
 *
 */
public class PasswordUtilsTest {
	
	@Test
	public void decryptPassword() {
		
		
		assertEquals("Password decrypted successfully", "pass", PasswordUtils.decrypt("d3EZNGOxjg1BPkAM94UYOA==") );
		
	}
}
