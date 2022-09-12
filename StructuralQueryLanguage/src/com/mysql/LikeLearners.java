package com.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LikeLearners {

	public static void main(String[] args) throws ClassNotFoundException ,SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost/database1","root","root");
		System.out.println("Database is connection permission is granted!");
		
		Statement stmt = conn.createStatement();
	/*	String sql = "SELECT * from learners WHERE lname LIKE 'A%'";
		ResultSet rs = stmt.executeQuery(sql);*/
		  
		ResultSet rs = stmt.executeQuery("SELECT lname from learners WHERE lname LIKE 'A%'");
		
		while(rs.next())
		{
			System.out.println("LEARNERSNAME :"+rs.getString("lname"));
		}
		System.out.println("Table has shown!");
	}

}
