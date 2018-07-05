package com.bridgelabz.loginapplication.controllers;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MyHttpListener
 *
 */
@WebListener
public class MyHttpListener implements HttpSessionListener {
	static int totalUser = 0;
	static int currentUser = 0;

	public void sessionCreated(HttpSessionEvent session) {
		totalUser++;
		currentUser++;

		System.out.println("sessionCreated and sessionID-->" + session.getSession().getId());
		System.out.println("Total user" + totalUser);
		System.out.println("Current user" + currentUser);
	}

	public void sessionDestroyed(HttpSessionEvent session) {
		System.out.println("sessionDestroyed and sessionID--> " + session.getSession().getId());
		currentUser--;
		System.out.println("Current user" + currentUser);
	}

}
