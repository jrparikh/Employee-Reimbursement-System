package com.Reimbursement.Dao;

import java.util.List;

import com.Model.Reimbursement;
import com.Model.User;

public interface ReimbursementDao {

	//CRUD methods
		//CREATE
		public int insertReimbursement(Reimbursement r);
		
		//READ
		
		public Reimbursement selectReimbursementById(int id);
		
		public List<Reimbursement> selectAllReimbursements();
		public List<Reimbursement> selectAllReimbursementsByName(String name);
		public List<Reimbursement> selectAllReimbursementsByType(String type);
		public List<Reimbursement> selectAllReimbursementsByPending(int status);
		public List<Reimbursement> selectAllReimbursementsByName_Type(String name, String type);
		public List<Reimbursement> selectAllReimbursementsByName_Pending(String name, int status);
		public List<Reimbursement> selectAllReimbursementsByType_Pending(String type, int status);
		public List<Reimbursement> selectAllReimbursementsByName_Type_Pending(String name, String type, int status);
		
		
		
		
		// UPDATE
		public int updateReimbursement(Reimbursement r);
		
		// DELETE
		//public int deleteReimbursement(int id);

}
