package com.sogeti.digital.test.utils;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.Test;

import com.sogeti.digital.utils.DBUtils;

public class DBUtilsTest {
	

	@Test
	public void getResultSet() throws SQLException {
		
		assertNotNull("ResultSet object is null", DBUtils.getResultSet("select * from stock.person"));
	}
	
	@Test
	public void runQuery() {
		
		try {
			
			DBUtils.runQuery("Update stock.person SET lastname='ireland1' where ID=1");
			DBUtils.runQuery("Update stock.person SET lastname='ireland' where ID=1");	
	
		} catch(SQLException e) {
			System.out.println("Exception in 'runQuery' test" + e.getMessage());
			fail("runQuery test has failed to update stock.person table");			
		}
	}

}
