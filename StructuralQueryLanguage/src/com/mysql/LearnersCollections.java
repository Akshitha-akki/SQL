package com.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LearnersCollections {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");		
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:mysql://localhost/database1","root","root");
		System.out.println("Database is connection permission is granted!");
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from learners");
		
		ArrayList<LearnersTableSetGet> alist = new ArrayList<LearnersTableSetGet>();
		while(rs.next())
		{
			LearnersTableSetGet l = new LearnersTableSetGet();
			l.setLid(rs.getInt("lid"));
			l.setLname(rs.getString("lname"));
			l.setCity(rs.getString("city"));
			alist.add(l);
		}
		for(LearnersTableSetGet lt : alist)
		{
			System.out.println("Lid : "+lt.getLid());
			System.out.println("Lname : "+lt.getLname());
			System.out.println("city : "+lt.getCity());
		}
	}
}
