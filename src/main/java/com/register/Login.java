package com.register;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String myemail=req.getParameter("email1");
		String mypass=req.getParameter("pass1");
		
		PrintWriter out=res.getWriter();
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/registration","root","2532003H@rsh");
			
			PreparedStatement pst=con.prepareStatement("Select * from student where email=? and password= ?");
			
		    pst.setString(1, myemail);
		    pst.setString(2, mypass);
		    
		    
		    ResultSet rs=pst.executeQuery();
			if(rs.next() && myemail!="" && mypass!="")
			{
				HttpSession hs=req.getSession();
				hs.setAttribute("my_name", rs.getString("name"));
				RequestDispatcher rd=req.getRequestDispatcher("/Profile.jsp");
				rd.include(req, res);
			}
			else
			{
				res.setContentType("text/html");
				out.println("<h3 style='color:red'>Email And Password didn't matach </h3>");
				
				RequestDispatcher rd=req.getRequestDispatcher("/login.jsp");
				rd.include(req, res);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
			res.setContentType("text/html");
			out.println("<h3 style='color:red'>	Exception Occured "+e.getMessage() +" </h3>");
			
			RequestDispatcher rd=req.getRequestDispatcher("/login.jsp");
			rd.include(req, res);
		}

	
	}

}
