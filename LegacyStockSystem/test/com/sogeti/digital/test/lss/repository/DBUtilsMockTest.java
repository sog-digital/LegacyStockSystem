package com.sogeti.digital.test.lss.repository;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.sogeti.digital.utils.DBUtils;

import mockit.Expectations;
import mockit.Injectable;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;

@RunWith(JMockit.class)
public class DBUtilsMockTest {
	
	@Injectable
	private ResultSet rs;
	
	@Mocked
	private DBUtils dbUtils;
	
	@Test
	public void getResultSet() throws SQLException {
		
		new Expectations() {
			
			{
				
				DBUtils.getResultSet("select * from stock.person");
				result = rs;
				rs.next();
				result = true;
			}	
		};
		
		assertTrue("ResultSet object is null", DBUtils.getResultSet("select * from stock.person").next());
	}
	
	@Test
	@Ignore public void runQuery() {

		try {
			
			DBUtils.runQuery("Update stock.person SET lastname='ireland1' where ID=1");
			DBUtils.runQuery("Update stock.person SET lastname='ireland' where ID=1");			
		} catch(SQLException e) {
			System.out.println("Exception in 'runQuery' test" + e.getMessage());
			fail("runQuery test has failed to update stock.person table");			
		}
	}

}
