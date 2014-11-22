package com.tutorialsdojo.ocjp.rowsets;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class JDBC_RowSetExample {

	

	public static String DBMSType   = "mysql";
	public static String serverName = "localhost";
	public static String portNumber = "3306";
	public static String username   = "sensei";
	public static String password   = "Password123";
	public static String dbName     = "tutorialsdojo";
	
	
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		
	
		
		JdbcRowSet rowSet = RowSetProvider.newFactory().createJdbcRowSet();  
		rowSet.setUrl("jdbc:"+DBMSType+"://"+serverName+":"
				+portNumber+"/"+dbName);  
		rowSet.setUsername(username);  
		rowSet.setPassword(password);  
		rowSet.setCommand("select * from ninja");
		rowSet.execute();
		
		while(rowSet.next()){
			System.out.println( rowSet.getInt(1) + " | " + rowSet.getString(2) );
		}
		
		// Will obliterate the last ninja (JonSan) completely. 
		rowSet.last();
		rowSet.deleteRow();
		
	
		rowSet.close();
		
		
		

	 

	}

}
