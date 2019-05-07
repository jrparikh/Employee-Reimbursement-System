package com.User.Dao;

//import java.util.List;

import com.Model.User;

public interface UserDao {

	//CRUD methods
	//CREATE
	public int insertUser(User u);
	
	//READ
	public User selectUserByName(String name);
	//public List<User> selectAllUsers();
	
	// UPDATE
	public int updateUser(User u);
	
	// DELETE //IF THEY GET FIRED
	public int deleteUser(String Username);
	
}