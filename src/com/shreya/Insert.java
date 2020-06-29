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
@WebServlet("/insert")
public class Insert extends HttpServlet{
	Connection con;
	@Override
	protected void service(HttpServletRequest req,HttpServletResponse res)throws ServletException{
	try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emploee", "root","root");
		PreparedStatement pstmt=con.prepareStatement("insert into info_emp(id,name,address) values(?,?,?) ");
	     
	      String id=req.getParameter("ids");
	      String name=req.getParameter("names");
//	      int idd =Integer.parseInt(id);
	      String addres=req.getParameter("addres");
		pstmt.setString(3, addres);
		pstmt.setString(2, name);
		pstmt.setString(1, id);
		pstmt.execute();
		System.out.println("insertion done");
		PrintWriter pr=res.getWriter();
		pr.print("insertion done");
		
		
	}
	catch (Exception e) {
		e.printStackTrace();
		System.out.println("connection not done");
	}
	}
}
