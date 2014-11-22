package com.tutorialsdojo.ocjp;

import java.sql.*;

public class InsertToDatabaseExample {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		//insert into ninja (id ,name, skill, birthdate) values (1, "Naruto", "Rasengan",now());


		Connection conn = ConnectToDatabaseExample.getConnection();
		Statement stmt =  conn.createStatement();
		conn.setAutoCommit(false);
		Savepoint sp1 = conn.setSavepoint("sp1");
		stmt.executeUpdate("insert into ninja (id ,name, skill) "
				+ "values (16, 'Megane ', 'death ray')");
		
		SelectFromDatabaseExample.viewTableContents("ninja");
		System.out.println("======================================");



		Savepoint sp2 = conn.setSavepoint("sp2");
		
		stmt.executeUpdate("insert into ninja (id ,name, skill) "
				+ "values (17, 'JonSan ', 'Persistence ')");
		//conn.commit();	
		
		System.out.println("======================================");
		
		
		SelectFromDatabaseExample.viewTableContents("ninja");
		
		conn.commit();
		
		//conn.rollback(sp1);

		conn.commit();
		
		conn.close();
		
	}

}
