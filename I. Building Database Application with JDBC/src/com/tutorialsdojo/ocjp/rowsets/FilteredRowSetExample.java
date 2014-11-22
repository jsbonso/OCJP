package com.tutorialsdojo.ocjp.rowsets;

import java.sql.SQLException;

import javax.sql.RowSet;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.FilteredRowSet;
import javax.sql.rowset.Predicate;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class FilteredRowSetExample implements Predicate{

	public static void main(String[] args) throws SQLException {
	
		RowSetFactory rsf = RowSetProvider.newFactory();
		CachedRowSet rowSet = rsf.createFilteredRowSet();
		
		rowSet.setUrl("jdbc:mysql://localhost:3306/tutorialsdojo");  
		rowSet.setUsername("sensei");  
		rowSet.setPassword("Password123");  
		rowSet.setCommand("select * from ninja");
		rowSet.execute();
		
		while(rowSet.next()){
			System.out.println(rowSet.getInt(1) + " | " + rowSet.getString(2));
		}
		
	}
	

	@Override
	public boolean evaluate(Object value, String columnName)
			throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean evaluate(RowSet rs) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean evaluate(Object value, int column) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	
	
	
	
	
	//
	

class AgeFilter implements Predicate {
  private int lowAge;

  private int highAge;

  private int columnIndex;

  private String columnName;

  public AgeFilter(int lowAge, int highAge, int columnIndex, String columnName) {
    this.lowAge = lowAge;
    this.highAge = highAge;
    this.columnName = columnName;
    this.columnIndex = columnIndex;
  }

  public AgeFilter(int lowAge, int highAge, int columnIndex) {
    this(lowAge, highAge, columnIndex, "age");
  }

  public boolean evaluate(Object value, String columnName) {
    boolean evaluation = true;
    if (columnName.equalsIgnoreCase(this.columnName)) {
      int columnValue = ((Integer) value).intValue();
      if ((columnValue >= this.lowAge) && (columnValue <= this.highAge)) {
        evaluation = true;
      } else {
        evaluation = false;
      }
    }
    return evaluation;
  }

  public boolean evaluate(Object value, int columnNumber) {
    boolean evaluation = true;
    if (columnIndex == columnNumber) {
      int columnValue = ((Integer) value).intValue();
      if ((columnValue >= this.lowAge) && (columnValue <= this.highAge)) {
        evaluation = true;
      } else {
        evaluation = false;
      }
    }
    return evaluation;
  }

  public boolean evaluate(RowSet rs) {
    if (rs == null) {
      return false;
    }

    FilteredRowSet frs = (FilteredRowSet) rs;
    boolean evaluation = false;
    try {
      int columnValue = frs.getInt(this.columnIndex);
      if ((columnValue >= this.lowAge) && (columnValue <= this.highAge)) {
        evaluation = true;
      }
    } catch (SQLException e) {
      return false;
    }
    return evaluation;
  }
}
}
