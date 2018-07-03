package com.bridgelabz.services;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class LoginFilter
 */
//@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

public void init(FilterConfig fc) throws ServletException {}
    
    public void doFilter(ServletRequest request, ServletResponse response,
         FilterChain chain) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        String username=request.getParameter("uname");
        String password=request.getParameter("password");
        String firstName=request.getParameter("firstname");
        String lastName=request.getParameter("lastname");
        String emailid=request.getParameter("emailid");
        String mobnum=request.getParameter("mobnum"); 
        
        if(username.equals("") || password.equals("")|| firstName.equals("")||
        		lastName.equals("") || emailid.equals("") || mobnum.equals("")){
        	out.println("All fields are mandatory!!");
        	System.out.println("filter");
        	RequestDispatcher rs = request.getRequestDispatcher("register.jsp");
            rs.include(request, response);
        }
   
        else
        {
        	chain.doFilter(request, response); 
            
        }
    }
   public void destroy() { }

}
