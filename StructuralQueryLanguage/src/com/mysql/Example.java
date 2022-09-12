package com.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Example 
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost/database1","root","root");
		System.out.println("Database is connection permission is granted!");
	 	
		/*//Creation of table
		 * Statement stmt = conn.createStatement();
	     String sql = "CREATE TABLE EG"+
					  "(id INTEGER not NULL, "+
					  "name VARCHAR(200),"+
					  "PRIMARY KEY (id))";
	    
	    
		stmt.executeUpdate(sql);
		System.out.println("Table is Created in the given Database!");*/
		Scanner scan = new Scanner(System.in);
		
		//Entering the elements for emp table.
	/*	System.out.println("Enter the di");
		int id = scan.nextInt();
		System.out.println("Enter the name");
		String name =scan.next();*/
		 
		/*//Printing
		System.out.println("eid : "+id+"\nFname :"+name);
		
		//PreparedStatement - a pre-compiled SQL statement and object provides a feature to execute a parameterized query.
		PreparedStatement preparedStmt = conn.prepareStatement(sql1);
		//Setting the Parameters
		preparedStmt.setInt(1,id);
		preparedStmt.setString(2,name);
		System.out.println("Recorded!");
		preparedStmt.executeUpdate();  */
		List<Example1> list = new ArrayList<>();
		list.add(new Example1(2,"Bhanu"));
		
	//	String sql1="INSERT INTO EG(id,name) VALUES(?,?)";
		String sql1 = "INSERT INTO EG VALUES(2,'Bhanu')";
				
		PreparedStatement p = conn.prepareStatement(sql1);
		
		conn.setAutoCommit(false);
		for(Iterator<Example1> iter = list.iterator();iter.hasNext();)
		{
			Example1 e = (Example1)iter.next();
			p.setInt(1,e.getId());
			p.setString(2,e.getName());
			p.addBatch();
		}
	//	Statement stmt 
		ResultSet rs = null;
	//	rs = sts;
		for(Example1 lt : list)
		{
			System.out.println("id : "+lt.getId());
			System.out.println("name : "+lt.getName());
		}
		System.out.println("Recorded!");
		 		
		scan.close();
		conn.close();
	}

}
