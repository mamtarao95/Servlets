package com.bridgelabz.loginapplication.controllers;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.loginapplication.models.User;
import com.bridgelabz.loginapplication.repositories.UserRepositoryImplementation;

/**
 * Servlet implementation class Registration
 */
public class RegistrationServlet extends HttpServlet {
	UserRepositoryImplementation dao=new UserRepositoryImplementation();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		User user = new User();
		user.setFirstName(request.getParameter("firstname"));
		user.setLastName(request.getParameter("lastname"));
		user.setUserName(request.getParameter("uname"));
		user.setPassword(request.getParameter("password"));
		user.setEmailid(request.getParameter("emailid"));
		user.setMobNumber(request.getParameter("mobnum"));
		try {
			if (dao.saveUser(user)) {
				response.sendRedirect("register.jsp");
				}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

	}
}
