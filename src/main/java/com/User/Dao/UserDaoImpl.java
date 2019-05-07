package com.User.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.Model.User;

public class UserDaoImpl implements UserDao{
	
	static{	System.out.println("INITIALIZED JDBC DRIVER");

    try {

        Class.forName("oracle.jdbc.driver.OracleDriver");
    	System.out.println("FINISHED INITIALIZING JDBC DRIVER");

    } catch (ClassNotFoundException e) {

        e.printStackTrace();

    }

}

	private static String url = "jdbc:oracle:thin:@oracle-instance1.cmseb0jui8wp.us-east-2.rds.amazonaws.com:1521:orcl";
	private static String username = "AlimWooden";
	private static String password = "Donkey123";
	
	Logger Log = Logger.getGlobal();
	
	@Override
	public int insertUser(User u) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO PROJECT1_USERS VALUES (?,?,?,?,?,?)");
			ps.setString(1, u.getUserName());
			ps.setString(2, u.getPassWord());
			ps.setString(3, u.getFirstName());
			ps.setString(4, u.getLastName());
			ps.setString(5, u.getEmail());
			ps.setInt(6, u.getStatus());
			Log.info("U Insert Query Prepared");
			ps.executeUpdate();
			Log.info("U Insert Query Executed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public User selectUserByName(String name) {
		User users = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM PROJECT1_USERS WHERE Username=?");
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();

			
			while(rs.next()) { System.out.println("Entered while loop " + users);
				users = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6));
				 System.out.println("After results" + users);
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}

		return users;
	}
	
//	@Override
//	public List<User> selectAllUsers() {
//		List<User> users = new ArrayList<>();
//		try (Connection conn = DriverManager.getConnection(url, username, password)) {
//			PreparedStatement ps = conn.prepareStatement("SELECT * FROM users");
//			ResultSet rs = ps.executeQuery();
//
//			while (rs.next()) {
//				users.add(new User());
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return users;
//	}

	@Override
	public int updateUser(User u) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE PROJECT1_USERS SET Password=?, First_Name=?, Last_Name=?, Email=?, Status=?  WHERE Username=?");
			
			ps.setString(1, u.getPassWord());
			ps.setString(2, u.getFirstName());
			ps.setString(3, u.getLastName());
			ps.setString(4, u.getEmail());
			ps.setInt(5, u.getStatus());
			ps.setString(6, u.getUserName());
			Log.info("U Update Query Prepared");
			ps.executeUpdate();
			Log.info("U Update Query Executed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteUser(String Username) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("DELETE FROM PROJECT1_USERS WHERE Username=?");
			ps.setString(1, Username);
			Log.info("U Delete Query Prepared");
			ps.executeUpdate();
			Log.info("R Delete Query Executed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}