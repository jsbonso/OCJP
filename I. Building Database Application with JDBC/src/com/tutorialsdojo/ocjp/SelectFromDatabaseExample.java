package com.tutorialsdojo.ocjp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectFromDatabaseExample {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		viewTableContents("ninja");

	}
	
	public static void viewTableContents(String tableName) throws SQLException{
		
		Connection conn;
		try {
			conn = ConnectToDatabaseExample.getConnection();
	
		Statement stmt =  conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from "+tableName);
		
		while(rs.next()){
			System.out.println(rs.getInt(1) + " | " + rs.getString(2) + " | "
					+rs.getString(3) + " | " + rs.getDate(4));
		}
		
		conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	

}
