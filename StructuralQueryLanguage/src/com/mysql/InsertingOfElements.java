package com.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertingOfElements {

	public static void main(String[] args) throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost/database1","root","root");
		System.out.println("Database is connection permission is granted!");
		
		Statement stmt = conn.createStatement();
		//INSERTION OF ELEMENTS
		
		String sql="INSERT INTO EMP VALUES (504,'Park','jimin',26)";
		
		stmt.executeUpdate(sql);
		
		System.out.println("Elements are Inserted!");
		
		stmt.close();
		conn.close();
	}
}
 