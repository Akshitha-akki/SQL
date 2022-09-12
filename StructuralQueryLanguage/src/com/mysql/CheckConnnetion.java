package com.mysql;

import java.sql.Connection;
import java.sql.DriverManager;

public class CheckConnnetion {

	public static void main(String[] args)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");		
			Connection conn = null;
			conn = DriverManager.getConnection("jdbc:mysql://localhost/database1","root","root");
			System.out.println("Database is connected!");
			conn.close();
		}
		catch (Exception e)
		{
			System.out.println("Do not connect to Database - Error:"+e);
		}
	}
}
