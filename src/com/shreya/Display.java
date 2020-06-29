package com.shreya;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/display")
public class Display extends HttpServlet{
	Connection con;
	@Override
	protected void service(HttpServletRequest req,HttpServletResponse res)throws ServletException{
	try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emploee", "root","root");
		PreparedStatement pstmt=con.prepareStatement("Select * from info_emp");
	     
	    ResultSet res1 =pstmt.executeQuery();
	    while (res1.next()) {
	PrintWriter pr=res.getWriter();
	pr.print("employe id is "+res1.getString(1)+ "\nemploye name is "+res1.getString(2) +
	"\nemploye address is "+res1.getString(3)+"\n");		
		}
		
		
	}
	catch (Exception e) {
		e.printStackTrace();
		System.out.println("connection not done");
	}
	}
}
