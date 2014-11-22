package com.tutorialsdojo.ocjp.rowsets;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JoinRowSetExample {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		
		RowSetFactory rsf = RowSetProvider.newFactory();
		JoinRowSet rowSet = rsf.createJoinRowSet(); 
		
		rowSet.setUrl("jdbc:mysql://localhost:3306/tutorialsdojo");  
		rowSet.setUsername("sensei");  
		rowSet.setPassword("Password123");  
		rowSet.setCommand("select * from ninja");
		rowSet.execute();
		
		while(rowSet.next()){
			System.out.println( rowSet.getInt(1) + " | " + rowSet.getString(2) );
		}
	}

}
