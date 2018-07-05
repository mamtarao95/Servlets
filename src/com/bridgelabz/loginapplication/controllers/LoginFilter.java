package com.bridgelabz.loginapplication.controllers;

import java.io.IOException;
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

import com.bridgelabz.loginapplication.repositories.UserRepository;
import com.bridgelabz.loginapplication.repositories.UserRepositoryImplementation;

/**
 * Servlet Filter implementation class LoginFilter
 */
public class LoginFilter implements Filter {
UserRepository userRepository=new UserRepositoryImplementation();

	public void init(FilterConfig fc) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String username = request.getParameter("uname");
		String password = request.getParameter("password");
		String passAgain = request.getParameter("passwordAgain");
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String emailid = request.getParameter("emailid");
		String mobnum = request.getParameter("mobnum");

		if (username.equals("") || password.equals("") || firstName.equals("") || lastName.equals("")
				|| emailid.equals("") || mobnum.equals("")) {
			request.setAttribute("error", "All fields are mandatory!!");
			RequestDispatcher rs = request.getRequestDispatcher("register.jsp");
			rs.include(request, response);
		}

		else if (!password.equals(passAgain)) {
			request.setAttribute("error", "Your password did not matched!!");
			RequestDispatcher rs = request.getRequestDispatcher("register.jsp");
			rs.include(request, response);
		}

		else if (mobnum.length()!=10) {
			request.setAttribute("error", "Invalid mobile number!!");
			RequestDispatcher rs = request.getRequestDispatcher("register.jsp");
			rs.include(request, response);
		} else
			try {
				if (userRepository.checkEmail(emailid) == 1) {
					request.setAttribute("error", "EmailId already exist!!");
					RequestDispatcher rs = request.getRequestDispatcher("register.jsp");
					rs.include(request, response);
				}

				else if (!userRepository.validatePassword(password)) {
					request.setAttribute("error", "Invalid password!!");
					RequestDispatcher rs = request.getRequestDispatcher("register.jsp");
					rs.include(request, response);
				}

				else {
					chain.doFilter(request, response);
					HttpServletRequest req = (HttpServletRequest) request;

					HttpSession session = req.getSession();
					session.setAttribute("user", username);
					RequestDispatcher rs = request.getRequestDispatcher("registersuccess.jsp");
					rs.include(request, response);

				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}

	public void destroy() {
	}

}
