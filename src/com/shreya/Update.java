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

@WebServlet("/update")
public class Update extends HttpServlet{
	Connection con;
	@Override
	protected void service(HttpServletRequest req,HttpServletResponse res)throws ServletException{
	try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/emploee", "root","root");
		PreparedStatement pstmt=con.prepareStatement("update info_emp set address=? where id=? ");
	     
	      String id=req.getParameter("id");
	      int idd =Integer.parseInt(id);
	      String addres=req.getParameter("address");
		pstmt.setString(1, addres);
		pstmt.setInt(2, idd);
		pstmt.executeUpdate();
		System.out.println("update done");
		PrintWriter pr=res.getWriter();
		pr.print("updation done");
	}
	catch (Exception e) {
		
		System.out.println("connection not done");
	}

	}
}
