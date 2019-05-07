package com.example.Contollers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.Model.User;
import com.User.Dao.UserDaoImpl;

public class LoginController {

	final static Logger Log = Logger.getLogger(LoginController.class);
	public static String Login (HttpServletRequest request, HttpServletResponse response) {
		Log.info("Entered Login Controller");
	String name = request.getParameter("userName");
	System.out.println(name);
	String password = request.getParameter("passWord");
	System.out.println(password);
	
	UserDaoImpl UDI = new UserDaoImpl();
	//User user = new User();
	//User user = new User(name,password,"A", "W", "AW123",0);
	//UDI.insertUser(user); System.out.println("Finished creating User");
	
	User user = UDI.selectUserByName(name); 
	if(user == null) {System.out.println( " User is null");  return "/HTML/Redirected.html";}
	System.out.println(user.getUserName() + "   " + user.getPassWord());
	
	if(name.equals(user.getUserName()) & password.equals(user.getPassWord())) {
		request.getSession().setAttribute("User",user);
		if(user.getStatus() == 0) {return "/HTML/employee.html";}
		if(user.getStatus() == 1) {return "/HTML/financeManager.html";}
		
	}
	
		return "/HTML/Redirected.html";
		
	
	}
}
