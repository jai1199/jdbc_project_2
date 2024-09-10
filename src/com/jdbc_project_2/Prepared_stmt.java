package com.jdbc_project_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Prepared_stmt 
{
  public static void main(String[] args)
  {
	  String url = "jdbc:mysql://localhost:3306/employee_db";
	  String username = "root";
	  String password = "W123@jai";
	  String query = "select * from employee where emp_name = ?";
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver class loaded successfully");  
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	try {
		Connection con = DriverManager.getConnection("url,username,password");
		System.out.println("connection establish successfully");
		PreparedStatement ps = con.prepareStatement(query);
		ps.setString(1,"tom");
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			int id =rs.getInt("emp_id");
			String name = rs.getString("emp_name");
			int phno = rs.getInt("phone_no");
			String department = rs.getString("department");
			String email = rs.getString("email");
			double salary = rs.getDouble("salary");
			System.out.println("id" +id+ "name" +name+ "phno" +phno+ "department" +department+ "email" +email+ "salary" +salary);
		}
		con.close();
		ps.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
  }
}
