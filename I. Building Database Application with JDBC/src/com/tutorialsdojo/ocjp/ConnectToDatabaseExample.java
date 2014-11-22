package com.tutorialsdojo.ocjp;

import java.sql.*;

import javax.sql.RowSetEvent;  
import javax.sql.RowSetListener;  

public class ConnectToDatabaseExample {
	
	public static String DBMSType   = "mysql";
	public static String serverName = "localhost";
	public static String portNumber = "3306";
	public static String username   = "sensei";
	public static String password   = "Password123";
	public static String dbName     = "tutorialsdojo";



	private static Connection conn = null;

	public static void main(String[] args) {
		System.out.println("LOG: Start.");
		
		try{
			getConnection();
			getListOfNinjas();
			
		}catch (Exception ex){
			
		}
		
		System.out.println("LOG: End.");
		
	}
	private static void getListOfNinjas(){
		
	}
	
	/*
	 * private static void checkDriver(){
	 *
		try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            System.out.println("ERROR: No mySQL driver found.");
        }
	}*/
	
	private static String getDatabaseURL(){
		
		// Format: 
		// jdbc:mysql://localhost:3306/tutorialsdojo?user=sensei&password=Password123
		
		String dbURL="jdbc:"+DBMSType+"://"+serverName+":"
				+portNumber+"/"+dbName+"?user="+username+"&password="
				+password;
		
		return dbURL;
	}
	public static Connection getConnection() throws SQLException{
		//checkDriver();
		String dbURL = getDatabaseURL();
		
		try{
			
		//conn = DriverManager.getConnection(dbURL);
		conn = DriverManager.getConnection("jdbc:"+DBMSType+"://"+serverName+":"
				+portNumber+"/"+dbName, username, password);
	
		
		
		
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("ERROR: SQLException occured: " + ex.getMessage());
		    ex.printStackTrace();
		}
		
		System.out.println("Connection established.");
		return conn;
		
	}

}
