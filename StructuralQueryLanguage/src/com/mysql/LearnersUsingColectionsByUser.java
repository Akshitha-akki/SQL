package com.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


public class LearnersUsingColectionsByUser {

	public static void main(String[] args) throws ClassNotFoundException,SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost/database1","root","root");
		System.out.println("Database is connection permission is granted!");
		
		Statement stmt = conn.createStatement();
		ArrayList<LearnersTableSetGet> alist =new ArrayList<LearnersTableSetGet>();
		Scanner scan =new Scanner(System.in);
		int lid;
		String lname,city;
		while(true)
		{
			System.out.println("Click the 1 - Add details");
			System.out.println("Click the 2 - displaying of Students details");
			System.out.println("Click the 3 - exit");
			System.out.println("Enter the choice : ");
			int choice= scan.nextInt();
			
			ResultSet rs = null;
			switch(choice)
			{
			 case 1 : //Entering the Elements
				      System.out.println("Enter the lid");
  					  lid = scan.nextInt();
					  System.out.println("Enter the lname");
					  lname=scan.next();
					  System.out.println("Enter the City");
					  city=scan.next();
					  
					  rs = stmt.executeQuery("INSERT INTO EMP values('" + lid + "','" + lname + "','" + city + "')");
					  while(rs.next())
						{
							LearnersTableSetGet l = new LearnersTableSetGet();
							l.setLid(lid);
							l.setLname(lname);
							l.setCity(city);
						/*	l.setLid(rs.getInt("lid"));
							l.setLname(rs.getString("lname"));
							l.setCity(rs.getString("city"));*/
							alist.add(l);
						}
					  System.out.println("Learners record is added!");
					  break;
			 case 2: 
				 rs = stmt.executeQuery("select * from learners");
				 while(rs.next())
					{
						LearnersTableSetGet l = new LearnersTableSetGet();
						l.setLid(rs.getInt("lid"));
						l.setLname(rs.getString("lname"));
						l.setCity(rs.getString("city"));
						alist.add(l);
					}
				 for(LearnersTableSetGet lt1 : alist)
					{
						System.out.println("Lid : "+lt1.getLid());
						System.out.println("Lname : "+lt1.getLname());
						System.out.println("city : "+lt1.getCity());
					}
			        break;
			 case 3: System.exit(0);
	    		     break;
			 default:
			    	System.out.println("Invaild data");
			    	break;
			}
		}

	}

}
