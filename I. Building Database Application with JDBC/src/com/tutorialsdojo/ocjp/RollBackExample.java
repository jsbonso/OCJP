package com.tutorialsdojo.ocjp;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class RollBackExample {
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		
		// Example of a nameless SavePoint
		
		Connection conn = ConnectToDatabaseExample.getConnection();
		Statement stmt =  conn.createStatement();
		conn.setAutoCommit(false);
		
	
		
		stmt.executeUpdate("insert into ninja (id ,name, skill) "
				+ "values (28, 'test ', 'skill')");
		
		SelectFromDatabaseExample.viewTableContents("ninja");
		System.out.println("======================================");

		
		// Behold, a wild nameless SavePoint appeared! 
		// This should 
		Savepoint sp1 = conn.setSavepoint("sp1");
		
		
		stmt.executeUpdate("insert into ninja (id ,name, skill) "
							+ "values (29, 'test ', 'skill ')");
		
		System.out.println("======================================");
		
		
		SelectFromDatabaseExample.viewTableContents("ninja");

		// Will only rollback from Sp1 SavePoint and 
		//not on the first ever insert statement
		
		conn.rollback(sp1);

		conn.commit();
		
		conn.close();
		
		
	}
}
