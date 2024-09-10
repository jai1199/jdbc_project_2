package com.jdbc_project_2;
//delete query
import java.sql.*;
public class Deletequery 
{
  public static void main(String[] args) 
  {
	  String url = "jdbc:mysql://localhost:3306/student_jdbc_1";
	  String username = "root";
	  String password = "W123@jai";
	  String query = "DELETE FROM STUDENT_DETAIL WHERE ROLLNO=117;";
	  String query1 = "delete from student_detail where rollno=119";
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("driver class loaded successfully");
	} 
	catch (ClassNotFoundException e) 
	{
		e.printStackTrace();
	}
	try {
		Connection con = DriverManager.getConnection(url,username,password);
		System.out.println("connection esatablish successfully");
		Statement stmt = con.createStatement();
		int rowsaffected = stmt.executeUpdate(query);
		int row = stmt.executeUpdate(query1);
		if(rowsaffected > 0)
		{
			System.out.println("data deleted successfully " + rowsaffected + "rows");
		}
		else
		{
			System.out.println("deletion failed");
		}
		
		  if(row>0) {
			  System.out.println("rows deleted " + row + "row");
			  }
		  else 
		  {
		  System.out.println("no rows deleted");
		  }
		 
		con.close();
		stmt.close();
		System.out.println("all the costly resource are closed successfully");
	} catch (SQLException e) {
		e.printStackTrace();
	}
  }
}
