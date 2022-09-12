package com.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertLearners {

	public static void main(String[] args) throws ClassNotFoundException , SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost/database1","root","root");
		System.out.println("Database is connection permission is granted!");
		
		Statement stmt = conn.createStatement();
		
		Scanner scan = new Scanner(System.in);
		
		//Entering the elements for emp table.
		System.out.println("Enter the lid");
		int lid = scan.nextInt();
		System.out.println("Enter the lname");
		String lname=scan.next();
		System.out.println("Enter the city");
		String city =scan.next();
		 
		String sql = "Insert into learners values ('"+ lid+"','" + lname+"','"+city+ "')";
		
		stmt.executeUpdate(sql);
		System.out.println("Insertion done in Database"); 
		scan.close();
		stmt.close();
		conn.close();
	}

}
