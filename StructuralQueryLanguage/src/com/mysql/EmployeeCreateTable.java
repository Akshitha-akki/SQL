package com.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class EmployeeCreateTable {

	public static void main(String[] args) 
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");		
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost/database1","root","root");
			System.out.println("Database is connected!");
			
			Statement stmt = conn.createStatement();
		 	//Creation of table
		 /* String sql = "CREATE TABLE EMP"+
						  "(eid INTEGER not NULL, "+
						  "firstname VARCHAR(200),"+
						  "lastname VARCHAR(200),"+
						  "age INTEGER, "+
						  "PRIMARY KEY (eid))";
			stmt.executeUpdate(sql);
			System.out.println("Table is Created in the given Database!"); */
		 /* OUTPUT:
		        mysql> desc emp;
				+-----------+--------------+------+-----+---------+-------+
				| Field     | Type         | Null | Key | Default | Extra |
				+-----------+--------------+------+-----+---------+-------+
				| eid       | int          | NO   | PRI | NULL    |       |
				| firstname | varchar(200) | YES  |     | NULL    |       |
				| lastname  | varchar(200) | YES  |     | NULL    |       |
				| age       | int          | YES  |     | NULL    |       |
				+-----------+--------------+------+-----+---------+-------+
		  */	
			//Insertion of elements
		/*	String sql="INSERT INTO EMP VALUES (501,'Stven','john',27)";
			stmt.executeUpdate(sql);
			System.out.println("Insertion done in Database");  */
		/*  OUTPUT
		 * 	mysql> select * from emp;
		 	+-----+-----------+----------+------+
		 	| eid | firstname | lastname | age  |
		 	+-----+-----------+----------+------+
		 	| 501 | Stven     | john     |   27 |
		 	+-----+-----------+----------+------+
		 	1 row in set (0.00 sec)
		*/	
			//Deletion of element.
			/*String sql = "DELETE FROM EMP WHERE lastname = 'Tom' ";
			stmt.executeUpdate(sql);
			System.out.println("Element is deleted!");*/
			
			Scanner scan = new Scanner(System.in);
			
			//Entering the elements for emp table.
			System.out.println("Enter the edi");
			int eid = scan.nextInt();
			System.out.println("Enter the Firstname");
			String firstname =scan.next();
			System.out.println("Enter the Lastname");
			String lastname =scan.next();
			System.out.println("Enter the age");
			int age = scan.nextInt();
			
			//Printing
			System.out.println("eid : "+eid+"\nFname :"+firstname+"\nlname :"+lastname+"\nage :"+age);
			
			//Inserting the values.
		/*	String sql1="INSERT INTO EMP(eid,firstname,lastname,age) VALUES(?,?,?,?)";
			
			//PreparedStatement - a pre-compiled SQL statement and object provides a feature to execute a parameterized query.
			PreparedStatement preparedStmt = conn.prepareStatement(sql1);
			
			//Setting the Parameters
			preparedStmt.setInt(1,eid);
			preparedStmt.setString(2, firstname);
			preparedStmt.setString(3, lastname);
			preparedStmt.setInt(4, age);
			
			preparedStmt.executeUpdate(); */
			
				String query = "INSERT INTO EMP values('" + eid + "','" + firstname + "','" + lastname + "','"+ age + "')";
				stmt.executeUpdate(query);
				System.out.println("Insertion done in Database"); 
			 
			 
			scan.close();
			conn.close();
		}
		catch (Exception e)
		{
			 e.printStackTrace();
		}
    }
}
