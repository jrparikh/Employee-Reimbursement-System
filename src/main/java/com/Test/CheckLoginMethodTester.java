package com.Test;

import java.util.ArrayList;

import com.Model.User;


public class CheckLoginMethodTester {

	static boolean CheckForUsers(String UserN, String password, ArrayList<User> U) 
	{	//for each customer login attempt, the Username and Password is checked against Database

		boolean check = false; int i;int j;
		//boolean to be returned
		//int i to return compareTo function output (compares string input to User username records
		//int j = customer records password
		ArrayList<User> Users = U;
				for (User User : Users) 
				{
					i = User.getUserName().compareTo(UserN); j = User.getPassWord().compareTo(password);	
					
					if((i == 0) & (j == 0)) 
					{
						return true; 
					}
				}	
				return check;//else return false
	}
	
}
