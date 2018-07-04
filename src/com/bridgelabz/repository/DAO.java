package com.bridgelabz.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgelabz.model.User;

public class DAO {
	private static Connection connection = null;
	private static PreparedStatement preparedStatement = null;
	private static ResultSet resultSet = null;

	public static Connection getConnection() throws ClassNotFoundException {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?useSSL=false", "dbuser",
					"password");
		} catch (SQLException e) {
			System.out.println("Error in establishing connection");
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * Method to close all the connections
	 * @return 
	 */
	public void closeConnection() {
		if (resultSet != null) {
			try {
				resultSet.close();

			} catch (SQLException e) {
				e.printStackTrace();

			}
		}
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	
	/**
	 * Function to check whether a user is present in database or not
	 * 
	 * @param uname
	 * @param password
	 * @return
	 * @throws ClassNotFoundException 
	 * @throws SQLException 
	 */
	public static boolean checkUser(String uname, String password) throws ClassNotFoundException, SQLException {
		boolean found = false;
		connection=getConnection();
			String query = "select * from servletlogindetail where username=? and password=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, uname);
			preparedStatement.setString(2, password);
			resultSet = preparedStatement.executeQuery();
			found = resultSet.next();
			return found;
	}

	
	public static boolean registerUser(User user) throws SQLException, ClassNotFoundException {
		connection=getConnection();
			String query = "insert into servletlogindetail values(?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, 0);
			preparedStatement.setString(2, user.getUserName());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getFirstName());
			preparedStatement.setString(5, user.getLastName());
			preparedStatement.setString(6, user.getMobNumber());
			preparedStatement.setString(7, user.getEmailid());
			int count = preparedStatement.executeUpdate();
			if (count == 7) {
				return true;
			}
		
		return false;
	}

	public static int checkEmail(String email) throws ClassNotFoundException, SQLException {
		boolean found = false;
		connection=getConnection();
	    String query = "select * from servletlogindetail where emailid=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();
			found = resultSet.next();
			if(found) {
				return 1;
			}
			/*else if(!validateEmail(email)) {
				return 2;
			}*/
		return 0;
	}

	
	public static boolean validatePassword(String password) {
		String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
		System.out.println(password.matches(pattern));
		return password.matches(pattern);
	}

	public static boolean validateEmail(String email) {
		String pattern = "/^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$/";
		return email.matches(pattern);
	}
}
