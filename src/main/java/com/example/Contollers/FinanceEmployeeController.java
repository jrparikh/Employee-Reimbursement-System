package com.example.Contollers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.Model.Reimbursement;
import com.Model.User;
import com.Reimbursement.Dao.ReimbursementDaoImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FinanceEmployeeController {
	
	final static Logger Log = Logger.getLogger(EmployeePortalController.class);
	
	public static String FMSubmitT(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Entered FMportalController");
		User user = (User)request.getSession().getAttribute("User");
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(user));
			Log.info(user.getUserName()  +  " has logged in");
		}catch(JsonProcessingException e){
			System.out.println("Jackson tool not working");
		}catch(IOException e) {
			e.printStackTrace();
		}		
		return "/HTML/financeManager.html";
	}
	
	
public static String GrabList(HttpServletRequest request, HttpServletResponse response) {
		
		ReimbursementDaoImpl RDI = new ReimbursementDaoImpl();
		//System.out.println("User is: " + user.getFirstName() + " " + user.getLastName());
		List<Reimbursement> RIListALL =  RDI.selectAllReimbursements();
		request.getSession().setAttribute("RIListALL",RIListALL);

		
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(RIListALL));
			Log.info("Table has been updated");
		}catch(JsonProcessingException e){
			System.out.println("Jackson tool not working");
		}catch(IOException e) {
			e.printStackTrace();
		}		
		return "/HTML/financeManager.html";
	}
	
	
	

	public static String Approve(HttpServletRequest request, HttpServletResponse response) {
		//User user = (User)request.getSession().getAttribute("User");
		String id = request.getParameter("reimbID");
		String approve = request.getParameter("approveButton");
		String deny = request.getParameter("denyButton");
		Integer inId = Integer.parseInt(id);
		User manager = (User)request.getSession().getAttribute("User");
		
		ReimbursementDaoImpl rdi = new ReimbursementDaoImpl();
		Reimbursement reimb = rdi.selectReimbursementById(inId);
		if(reimb == null) {
			return "/HTML/financeManager.html";
		}
		
		reimb.setTicketResolver(manager.getUserName());
		
		if(approve == null) {
			reimb.setStatus(2);
			rdi.updateReimbursement(reimb);
			Log.info("Reimbursement " + reimb.getReimburseId() + " DENIED!!!");
		}
		
		if(deny == null) {
			reimb.setStatus(1);
			rdi.updateReimbursement(reimb);
			Log.info("Reimbursement " + reimb.getReimburseId() + " Ticket approved");
		}	
		return "/HTML/financeManager.html";
	}	
}
