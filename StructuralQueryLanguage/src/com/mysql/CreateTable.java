package com.mysql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class CreateTable {
	public static void main(String[] args) throws SQLException {
		try 
		{
			//Establishing the connection.
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = null;
		    conn = DriverManager.getConnection("jdbc:mysql://localhost/database1","root","root");
			System.out.println("Database is connected!");
			
			//Creating the table
			Statement stmt = conn.createStatement(); // statement interface is used to create SQL basic statements in Java.
			
			//CREATING TABLE
			String sql = "CREATE TABLE EMPLOYEE"+
						 "(eid INTEGER not NULL, "+
						 "firstname VARCHAR(200),"+
						 "lastname VARCHAR(200),"+
						 "age INTEGER, "+
						 "PRIMARY KEY (eid))";
			//executeUpdate this method to execute SQL statements
			//for which you expect to get a number of rows affected.Like an INSERT, UPDATE, or DELETE.
			stmt.executeUpdate(sql);
			System.out.println("Table is Created in the given Database!");
			
			//Closing the connnection.
			conn.close();	
		}
		//If not connected to database then ,catch block will be excuted.
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
	}		
}
