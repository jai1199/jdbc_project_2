package com.jdbc_project_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//data retreving from database
public class Sampe 
{
 public static void main(String[] args) 
 {
	 String url = "jdbc:mysql://localhost:3306/student_jdbc_1";
	 String username ="root";
	 String pass ="W123@jai";
	 String query = "select * from student_detail";
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("driver class loaded successfully");
	} catch (ClassNotFoundException e) {
		System.out.println(e.getMessage());
	}
	try {
		Connection con = DriverManager.getConnection(url,username,pass);
		System.out.println("connection establish sucessfully");
		Statement stmt = con.createStatement();
	    ResultSet rs = stmt.executeQuery(query);
	    rs.next();
	    int rollno = rs.getInt(1);
	    System.out.println(" rollno " +rollno);
	    String snamel = rs.getString("snamel");
	    System.out.println("name " +snamel);
	    String email = rs.getString("email");
	    System.out.println("email"+email);
	    String branch= rs.getString("branch");
	    System.out.println("branch " +branch);
	    String phno = rs.getString("phno");
	    System.out.println("phno " +phno);
	    stmt.close();
	    con.close();
	} catch (SQLException e) {
	    e.printStackTrace();
	}
	
 }
}
