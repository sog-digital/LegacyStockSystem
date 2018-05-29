package com.sogeti.digital.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {

	private static Statement statement = null;
	private static ResultSet resultSet = null;
	private  static  Connection con = null;

	// My SQL DB settings 
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String  dbUrl = "jdbc:mysql://localhost/stock";
	//private static final String dbName = "stock";
	private static final String userName = "root";
	private static final String password = "Sogeti2018";


	private static Connection loadDriver() throws SQLException {

		try {
			Class.forName(driver);
		} catch(ClassNotFoundException cnfe) {
			System.out.println(cnfe.getMessage());
		}

		con = DriverManager.getConnection(dbUrl +"?"
				+ "user="+userName +"&password="+ password +"");
		return con;

	}
	/**
	 * to get a result set of a query
	 * @param query
	 * @return
	 * @throws SQLException
	 */

	public static ResultSet getResultSet(String query) throws SQLException {

		Connection con = loadDriver();
		ResultSet rs;
		Statement statement;
		statement = con.createStatement();

		rs = statement.executeQuery(query);
		//close();
		return rs;
	}

	public static void runQuery(String query) throws SQLException {

		ResultSet rs;
		PreparedStatement st = con.prepareStatement(query);
		st.executeUpdate();
		//close();
	}


	// You need to close the resultSet
	private static  void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (con != null) {
				con.close();
			}
		} catch (Exception e) {

		}
	}
}
