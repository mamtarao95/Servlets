package com.bridgelabz.loginapplication.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgelabz.loginapplication.models.User;

public class UserRepositoryImplementation implements UserRepository{

	@Override
	public Connection getConnection() throws ClassNotFoundException {
		Connection connection = null;
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

	@Override
	public void closeConnection(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
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

	@Override
	public User getUserByUserName(String uname) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		User user = new User();
		String query = "select * from servletlogindetail where username=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, uname);
		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			user.setUserName(resultSet.getString(2));
			user.setPassword(resultSet.getString(3));
			closeConnection(resultSet, preparedStatement, connection);
			return user;
		}
		return null;
	}

	@Override
	public boolean saveUser(User user) throws SQLException, ClassNotFoundException {
		Connection connection = getConnection();
		ResultSet resultSet = null;
		String query = "insert into servletlogindetail values(?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, 0);
		preparedStatement.setString(2, user.getUserName());
		preparedStatement.setString(3, user.getPassword());
		preparedStatement.setString(4, user.getFirstName());
		preparedStatement.setString(5, user.getLastName());
		preparedStatement.setString(6, user.getMobNumber());
		preparedStatement.setString(7, user.getEmailid());
		int count = preparedStatement.executeUpdate();
		closeConnection(resultSet, preparedStatement, connection);
		if (count == 7) {
			return true;
		}
		return false;
	}

	@Override
	public int checkEmail(String email) throws ClassNotFoundException, SQLException {
		boolean found = false;
		ResultSet resultSet = null;
		Connection connection = getConnection();
		String query = "select * from servletlogindetail where emailid=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, email);
		resultSet = preparedStatement.executeQuery();
		found = resultSet.next();
		closeConnection(resultSet, preparedStatement, connection);
		if (found) {
			return 1;
		}
		return 0;
	}

	@Override
	public boolean validatePassword(String password) {
		String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";
		System.out.println(password.matches(pattern));
		return password.matches(pattern);
	}

	
	/**
	 * Function to validate email using regex
	 * 
	 * @param email
	 * @returns
	 */
	public boolean validateEmail(String email) {
		String pattern = "/^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$/";
		return email.matches(pattern);
	}

	
	/**
	 * Method to retrieve password of a particular user present in the database
	 * 
	 * @param RECIPIENT
	 *            UserName present in the database
	 * @return string Password of the given user
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public String getPassword(String RECIPIENT) throws ClassNotFoundException, SQLException {
		Connection connection = getConnection();
		String userPassword = null;
		String query = "select * from servletlogindetail where emailid=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, RECIPIENT);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			userPassword = resultSet.getString("password");
		}
		return userPassword;

	}
}
