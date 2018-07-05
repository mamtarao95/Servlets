package com.bridgelabz.loginapplication.controllers;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.loginapplication.models.User;
import com.bridgelabz.loginapplication.repositories.UserRepository;
import com.bridgelabz.loginapplication.repositories.UserRepositoryImplementation;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserRepository userRepository=new UserRepositoryImplementation();
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		User user=null;
		String username = request.getParameter("uname");
		String password = request.getParameter("psw");
		
		
		try {
			 user = userRepository.getUserByUserName(username);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error in connection with database");
			e.printStackTrace();
		}
		if(user!=null) {
			if(user.getPassword().equals(password)) {
				HttpSession session = request.getSession();
				session.setAttribute("user", username);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("Welcome.jsp");
				requestDispatcher.forward(request, response);
			}
			else {
				request.setAttribute("error", "Password is incorrect!!");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
				requestDispatcher.forward(request, response);
			}
		}
		else {
			request.setAttribute("error", "UserName doesn't exist!!");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
			requestDispatcher.forward(request, response);
		}
	}
}
