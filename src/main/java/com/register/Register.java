package com.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/regform")
public class Register extends HttpServlet 
{
		
		
		@Override
	protected void doPost(HttpServletRequest reg, HttpServletResponse res) throws ServletException, IOException 
		{
			String myname=reg.getParameter("name1");
			String myemail=reg.getParameter("email1");
			String mypass=reg.getParameter("pass1");
			String mygender=reg.getParameter("gender1");
			String mycity=reg.getParameter("city1");
			
			PrintWriter out=res.getWriter();
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","2532003H@rsh");
				
				PreparedStatement pst=con.prepareStatement("Insert into student values(?,?,?,?,?)");
				
				pst.setString(1, myname);
				pst.setString(2, myemail);
				pst.setString(3, mypass);
				pst.setString(4, mygender);
				pst.setString(5, mycity);
				
				
				int rs=pst.executeUpdate();
				if(rs>0)
				{
					res.setContentType("text/html");
					out.println("<h3 style='color:green'>User Register Successfully </h3>");
					
					RequestDispatcher rd=reg.getRequestDispatcher("/Form.jsp");
					rd.include(reg, res);
				}
				else
				{
					res.setContentType("text/html");
					out.println("<h3 style='color:red'>User Register Failed  </h3>");
					
					RequestDispatcher rd=reg.getRequestDispatcher("/Form.jsp");
					rd.include(reg, res);
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
				
				res.setContentType("text/html");
				out.println("<h3 style='color:red'>	Exception Occured "+e.getMessage() +" </h3>");
				
				RequestDispatcher rd=reg.getRequestDispatcher("/Form.jsp");
				rd.include(reg, res);
			}
		}

}


