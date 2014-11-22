package com.tutorialsdojo.ocjp.rowsets;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.sql.rowset.RowSetProvider;
import javax.sql.rowset.WebRowSet;

public class WebRowSetExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
			WebRowSet wrs = RowSetProvider.newFactory().createWebRowSet();
			wrs.setUrl("jdbc:mysql://localhost:3306/tutorialsdojo");
			wrs.setUsername("sensei");
			wrs.setPassword("Password123");
			wrs.setCommand("select * from ninja");
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
