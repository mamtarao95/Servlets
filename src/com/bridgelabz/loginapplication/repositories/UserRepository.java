package com.bridgelabz.loginapplication.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgelabz.loginapplication.models.User;

public interface UserRepository {
	/**
	 * Method to establish and return the connection
	 * 
	 * @return connection JDBC Connection
	 * @throws ClassNotFoundException
	 */
	public Connection getConnection() throws ClassNotFoundException;
	
	/**
	 * Method to close all the JDBC connection
	 * 
	 * @param resultSet
	 *            ResultSet
	 * @param preparedStatement
	 *            PreparedStatement
	 * @param connection
	 *            Connection
	 */
	public void closeConnection(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection);
	
	/**
	 * Method to verify whether a user is present in database or not
	 * 
	 * @param uname
	 * @param password
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public User getUserByUserName(String uname) throws ClassNotFoundException, SQLException;
	
	/**
	 * Function to save user in the database
	 * 
	 * @param user
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean saveUser(User user) throws SQLException, ClassNotFoundException;
	
	/**
	 * Function to verify already existing email in the database
	 * 
	 * @param email
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public int checkEmail(String email) throws ClassNotFoundException, SQLException ;
	
	
	/**
	 * Function to validate password using regex
	 * 
	 * @param password
	 * @return
	 */
	public boolean validatePassword(String password);
	
}
