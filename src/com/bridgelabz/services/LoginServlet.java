package com.bridgelabz.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.repository.DAO;

//	@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// get request parameters for userID and password
		String user = request.getParameter("uname");
		String pwd = request.getParameter("psw");

		try {
			if (DAO.checkUser(user, pwd)) {
				
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("Welcome.jsp");
				requestDispatcher.forward(request, response);

			} else {
				request.setAttribute("error", "Either username or password is incorrect!!");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
				requestDispatcher.forward(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}

}
