package com.shreya;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/delete")
public class Delete extends HttpServlet{
	Connection con;
	@Override
	protected void service(HttpServletRequest req,HttpServletResponse res)throws ServletException{
	try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emploee", "root","root");
		PreparedStatement pstmt=con.prepareStatement("delete from info_emp where id=? ");
	     
	      String id=req.getParameter("idd");
	
int idd=Integer.parseInt(id);
		pstmt.setInt(1, idd);
		pstmt.executeUpdate();
		System.out.println("deletion done");
		PrintWriter pr=res.getWriter();
		pr.print("deletion done");
		
		
	}
	catch (Exception e) {
		
		System.out.println("connection not done");
	}
	}
}
