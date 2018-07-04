package com.bridgelabz.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.model.User;
import com.bridgelabz.repository.DAO;


/**
 * Servlet implementation class Registration
 */
//@WebServlet("/Registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		  User user=new User();
		  user.setFirstName(request.getParameter("firstname"));
		  user.setLastName(request.getParameter("lastname"));
		  user.setUserName(request.getParameter("uname"));
		  user.setPassword(request.getParameter("password"));
		  user.setEmailid(request.getParameter("emailid"));
		  user.setMobNumber(request.getParameter("mobnum"));
		  try {
			if(DAO.registerUser(user)) {
				  out.println("registered!!");
				  response.sendRedirect("register.jsp");
				 
			  }
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		  
		  
		  
		  
	}
}

