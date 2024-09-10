package com.jdbc_project_2;

import java.sql.*;
//update query
public class updatedetails 
{
public static void main(String[] args) throws ClassNotFoundException, SQLException 
{
	String url="jdbc:mysql://localhost:3306/student_jdbc_1";
	String uname="root";
	String pass="W123@jai";
	String query="update student_detail set email='tony@999'where rollno IN(111,112)";
	Class.forName("com.mysql.cj.jdbc.Driver");
	System.out.println("driver loaded successfully");
	Connection con = DriverManager.getConnection(url,uname,pass);
	System.out.println("connection establish successfully");
	Statement stmt = con.createStatement();
	int rows = stmt.executeUpdate(query);
	if(rows>0)
	{
		System.out.println("rows updated successfully " +rows+" rows");
	}
	else
	{
		System.out.println("not updated");
	}
	con.close();
	stmt.close();
	System.out.println("closed all the resources successfully");
}
}
