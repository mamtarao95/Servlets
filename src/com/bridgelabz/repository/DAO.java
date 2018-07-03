package com.bridgelabz.repository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bridgelabz.model.User;

public class DAO {
	
	/**Function to check whether a user is present in database or not
	 * @param uname
	 * @param password
	 * @return
	 */
	public static boolean checkUser(String uname,String password) 
    {
     boolean found =false;
     Connection con=null;
		PreparedStatement preparedStatement=null;
		ResultSet rs=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?useSSL=false", "dbuser", "password");
			String query="select * from servletlogindetail where username=? and password=?";
			preparedStatement=con.prepareStatement(query);
			preparedStatement.setString(1,uname);
			preparedStatement.setString(2,password);
			rs=preparedStatement.executeQuery();
			found=rs.next();
			System.out.println(found);
			return found;
		}
			 catch(Exception e)
		     {
		   	  e.printStackTrace();
		     }
		     finally
		     {
		   	  try
		   	  {
		   		  if(con!=null)
		   		  {
		   			  con.close();
		   		  }
		   		  if(preparedStatement!=null)
		   		  {
		   			preparedStatement.close();
		   		  }
		   		  if(rs!=null)
		   		  {
		   			  rs.close();
		   		  }
		   	  
		   	  }
		   	 catch(SQLException e)
		   	  {
		   		  e.printStackTrace();
		   		  
		   		  }
		     }
		
		return false;
		}
	
	
	public static boolean registerUser(User user) {
		 Connection con=null;
		  PreparedStatement pstmt=null;
		  try
		  {
			  Class.forName("com.mysql.jdbc.Driver");
			  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb?useSSL=false", "dbuser", "password");
			  String query="insert into servletlogindetail values(?,?,?,?,?,?,?)";
			  pstmt=con.prepareStatement(query);
			  pstmt.setInt(1, 0);
			  pstmt.setString(2,user.getUserName());
			  pstmt.setString(3,user.getPassword());
			  pstmt.setString(4,user.getFirstName());
			  pstmt.setString(5,user.getLastName());
			  pstmt.setString(6,user.getMobNumber());
			  pstmt.setString(7,user.getEmailid());
			  int count=pstmt.executeUpdate();
			  if(count==7)
	          {
				 return true;
	          }
		  }
		  catch (Exception e) 
		  {
				e.printStackTrace();
			} finally 
		  {

				try {
					if (con != null) {
						con.close();
					}
					if (pstmt != null) {
						pstmt.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		return false;
	  }
	}
		

