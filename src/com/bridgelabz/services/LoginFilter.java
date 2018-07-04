package com.bridgelabz.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.bridgelabz.repository.DAO;

/**
 * Servlet Filter implementation class LoginFilter
 */
// @WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

	public void init(FilterConfig fc) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String username = request.getParameter("uname");
		System.out.println(username);
		String password = request.getParameter("password");
		String passAgain = request.getParameter("passwordAgain");
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String emailid = request.getParameter("emailid");
		String mobnum = request.getParameter("mobnum");

		if (username.equals("") || password.equals("") || firstName.equals("") || lastName.equals("")
				|| emailid.equals("") || mobnum.equals("")) {
			System.out.println("filter");
			request.setAttribute("error", "All fields are mandatory!!");
			RequestDispatcher rs = request.getRequestDispatcher("register.jsp");
			rs.include(request, response);
		}

		if (!password.equals(passAgain)) {
			request.setAttribute("error", "Your password did not matched!!");
			RequestDispatcher rs = request.getRequestDispatcher("register.jsp");
			rs.include(request, response);
		}

		if (mobnum.length() > 10) {
			request.setAttribute("error", "Invalid mobile number!!");
			RequestDispatcher rs = request.getRequestDispatcher("register.jsp");
			rs.include(request, response);
		}

		try {
			if (DAO.checkEmail(emailid) == 1) {
				request.setAttribute("error", "EmailId already exist!!");
				RequestDispatcher rs = request.getRequestDispatcher("register.jsp");
				rs.include(request, response);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (!DAO.validatePassword(password)) {
			request.setAttribute("error", "Invalid password!!");
			RequestDispatcher rs = request.getRequestDispatcher("register.jsp");
			rs.include(request, response);
		}

		else {
			System.out.println("success reg");
			chain.doFilter(request, response);
			HttpServletRequest req = (HttpServletRequest) request;

			HttpSession session = req.getSession();
			session.setAttribute("user",username);
			RequestDispatcher rs = request.getRequestDispatcher("registersuccess.jsp");
			rs.include(request, response);

		}

	}

	public void destroy() {
	}

}
