package com.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SortLearners {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost/database1","root","root");
		System.out.println("Database is connection permission is granted!");
		
		Statement stmt = conn.createStatement();
		//Ascending order
		ResultSet rs = stmt.executeQuery("SELECT * from learners order by lname");
		
		while(rs.next())
		{
			System.out.print("LEARNERSNAME :"+rs.getString("lname"));
		}
		System.out.println("\tTable has shown!");
	}

}
