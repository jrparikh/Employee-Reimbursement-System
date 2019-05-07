package com.example.Contollers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.Model.Reimbursement;
import com.Model.User;
import com.Reimbursement.Dao.ReimbursementDaoImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EmployeePortalController {

	final static Logger Log = Logger.getLogger(EmployeePortalController.class);
	
	public static String SubmitT(HttpServletRequest request, HttpServletResponse response) {
		Log.info("Entered EMPportalController");
		User user = (User)request.getSession().getAttribute("User");
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(user));
			Log.info(user.getUserName()  +  " has logged in");
		}catch(JsonProcessingException e){
			System.out.println("Jackson tool not working");
		}catch(IOException e) {
			e.printStackTrace();
		}		
		return "/HTML/employee.html";
	}
	
	public static String SubmitR(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Entered ReimbursementController Method");
		
		String amount = request.getParameter("reimbAmount");
		String type = request.getParameter("reimbType");
		String describe = request.getParameter("reimbExplain");
		User user = (User)request.getSession().getAttribute("User");
		
		Reimbursement RI = new Reimbursement(Double.parseDouble(amount),user.getUserName(),describe,0,type);
		ReimbursementDaoImpl RDI = new ReimbursementDaoImpl();
		RDI.insertReimbursement(RI);
		Log.info("Reimbursement Created by " + user.getUserName());
		
		request.getSession().setAttribute("User",user);
		return "/HTML/employee.html";
	}
	

	public static String PopulateTable(HttpServletRequest request, HttpServletResponse response) {
		
		User user = (User)request.getSession().getAttribute("User");
		ReimbursementDaoImpl RDI = new ReimbursementDaoImpl();
		//System.out.println("User is: " + user.getFirstName() + " " + user.getLastName());
		List<Reimbursement> RIList =  RDI.selectAllReimbursementsByName(user.getUserName());
		request.getSession().setAttribute("RIList",RIList);
//		for (Reimbursement RI : RIList) {
//			System.out.println(RI);
//		}
		
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(RIList));
			Log.info("Table has been updated");
		}catch(JsonProcessingException e){
			System.out.println("Jackson tool not working");
		}catch(IOException e) {
			e.printStackTrace();
		}		
		return "/HTML/employee.html";
	}
	

	
}
