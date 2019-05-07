package com.Reimbursement.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.Model.Reimbursement;

public class ReimbursementDaoImpl implements ReimbursementDao{
	
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
	public int insertReimbursement(Reimbursement u) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO Reimbursement_Table (Amount_Requested, Request_Author,Request_Description,Request_Category,Approved_Status) VALUES (?,?,?,?,?)");
			ps.setDouble(1, u.getAmount());
			ps.setString(2,u.getTicketAuthor());
			ps.setString(3,u.getDescription());
			ps.setString(4,u.getType());
			ps.setInt(5,u.getStatus());
			Log.info("R Insert Query Prepared");
			ps.executeUpdate();
			Log.info("R Insert Query Executed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

//
	//id
	@Override
	public Reimbursement selectReimbursementById(int id) {
		Reimbursement reimbursement = null;
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Reimbursement_Table WHERE Reimburse_ID=?");
			ps.setInt(1, id);
			Log.info("R Select Query Prepared");
			ResultSet rs = ps.executeQuery();
			Log.info("R Select Query Executed");
			while (rs.next()) {
				reimbursement = new Reimbursement(rs.getInt("Reimburse_ID"),rs.getDouble("Amount_Requested"),rs.getString("Request_Author"),rs.getString("Request_Resolver"),rs.getTimestamp("Submission_Time"),rs.getTimestamp("Resolved_Time"),rs.getString("Request_Description"),rs.getInt("Approved_Status"),rs.getString("Request_Category"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return reimbursement;
	}

	@Override
	public List<Reimbursement> selectAllReimbursementsByName(String name) {
		List<Reimbursement> reimbursement = new ArrayList<Reimbursement>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Reimbursement_Table WHERE Request_Author=?");
			ps.setString(1, name);
			Log.info("R Select Query Prepared");
			ResultSet rs = ps.executeQuery();
			Log.info("R Select Query Executed");
			while (rs.next()) {
				reimbursement.add(new Reimbursement(rs.getInt("Reimburse_ID"),rs.getDouble("Amount_Requested"),rs.getString("Request_Author"),rs.getString("Request_Resolver"),rs.getTimestamp("Submission_Time"),rs.getTimestamp("Resolved_Time"),rs.getString("Request_Description"),rs.getInt("Approved_Status"),rs.getString("Request_Category")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return reimbursement;
	}

	@Override
	public List<Reimbursement> selectAllReimbursementsByType(String type) {
		List<Reimbursement> reimbursement = new ArrayList<Reimbursement>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Reimbursement_Table WHERE Request_Category=?");
			ps.setString(1, type);
			Log.info("R Select Query Prepared");
			ResultSet rs = ps.executeQuery();
			Log.info("R Select Query Executed");
			
			while (rs.next()) {
				reimbursement.add(new Reimbursement(rs.getInt("Reimburse_ID"),rs.getDouble("Amount_Requested"),rs.getString("Request_Author"),rs.getString("Request_Resolver"),rs.getTimestamp("Submission_Time"),rs.getTimestamp("Resolved_Time"),rs.getString("Request_Description"),rs.getInt("Approved_Status"),rs.getString("Request_Category")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return reimbursement;
	}

	@Override
	public List<Reimbursement> selectAllReimbursementsByPending(int status) {
		List<Reimbursement> reimbursement = new ArrayList<Reimbursement>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Reimbursement_Table WHERE Approved_Status=?");
			ps.setInt(1, status);
			Log.info("R Select Query Prepared");
			ResultSet rs = ps.executeQuery();
			Log.info("R Select Query Executed");
			
			while (rs.next()) {
				reimbursement.add(new Reimbursement(rs.getInt("Reimburse_ID"),rs.getDouble("Amount_Requested"),rs.getString("Request_Author"),rs.getString("Request_Resolver"),rs.getTimestamp("Submission_Time"),rs.getTimestamp("Resolved_Time"),rs.getString("Request_Description"),rs.getInt("Approved_Status"),rs.getString("Request_Category")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return reimbursement;
	}

	@Override
	public List<Reimbursement> selectAllReimbursementsByName_Type(String name, String type) {
		List<Reimbursement> reimbursement = new ArrayList<Reimbursement>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Reimbursement_Table WHERE Request_Author=? AND Request_Category=? ");
			ps.setString(1, name);
			ps.setString(2, type);
			Log.info("R Select Query Prepared");
			ResultSet rs = ps.executeQuery();
			Log.info("R Select Query Executed");
			
			while (rs.next()) {
				reimbursement.add(new Reimbursement(rs.getInt("Reimburse_ID"),rs.getDouble("Amount_Requested"),rs.getString("Request_Author"),rs.getString("Request_Resolver"),rs.getTimestamp("Submission_Time"),rs.getTimestamp("Resolved_Time"),rs.getString("Request_Description"),rs.getInt("Approved_Status"),rs.getString("Request_Category")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return reimbursement;
	}

	@Override
	public List<Reimbursement> selectAllReimbursementsByName_Pending(String name, int status) {
		List<Reimbursement> reimbursement = new ArrayList<Reimbursement>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Reimbursement_Table WHERE Request_Author=? AND Approved_Status=? ");
			ps.setString(1, name);
			ps.setInt(2, status);
			Log.info("R Select Query Prepared");
			ResultSet rs = ps.executeQuery();
			Log.info("R Select Query Executed");
			
			while (rs.next()) {
				reimbursement.add(new Reimbursement(rs.getInt("Reimburse_ID"),rs.getDouble("Amount_Requested"),rs.getString("Request_Author"),rs.getString("Request_Resolver"),rs.getTimestamp("Submission_Time"),rs.getTimestamp("Resolved_Time"),rs.getString("Request_Description"),rs.getInt("Approved_Status"),rs.getString("Request_Category")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return reimbursement;
	}

	@Override
	public List<Reimbursement> selectAllReimbursementsByType_Pending(String type, int status) {
		List<Reimbursement> reimbursement = new ArrayList<Reimbursement>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Reimbursement_Table WHERE Request_Category=? AND Approved_Status=? ");
			ps.setString(1, type);
			ps.setInt(2, status);
			Log.info("R Select Query Prepared");
			ResultSet rs = ps.executeQuery();
			Log.info("R Select Query Executed");
			
			while (rs.next()) {
				reimbursement.add(new Reimbursement(rs.getInt("Reimburse_ID"),rs.getDouble("Amount_Requested"),rs.getString("Request_Author"),rs.getString("Request_Resolver"),rs.getTimestamp("Submission_Time"),rs.getTimestamp("Resolved_Time"),rs.getString("Request_Description"),rs.getInt("Approved_Status"),rs.getString("Request_Category")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return reimbursement;
	}

	@Override
	public List<Reimbursement> selectAllReimbursementsByName_Type_Pending(String name, String type, int status) {
		List<Reimbursement> reimbursement = new ArrayList<Reimbursement>();
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Reimbursement_Table WHERE Request_Author=? AND Request_Category=? AND Approved_Status=? ");
			ps.setString(1,name);
			ps.setString(2, type);
			ps.setInt(3, status);
			Log.info("R Select Query Prepared");
			ResultSet rs = ps.executeQuery();
			Log.info("R Select Query Executed");
			
			while (rs.next()) {
				reimbursement.add(new Reimbursement(rs.getInt("Reimburse_ID"),rs.getDouble("Amount_Requested"),rs.getString("Request_Author"),rs.getString("Request_Resolver"),rs.getTimestamp("Submission_Time"),rs.getTimestamp("Resolved_Time"),rs.getString("Request_Description"),rs.getInt("Approved_Status"),rs.getString("Request_Category")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return reimbursement;
	}
	
	@Override
	public List<Reimbursement> selectAllReimbursements() {
		List<Reimbursement> reimbursements = new ArrayList<>();
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM Reimbursement_Table");
			Log.info("R Select Query Prepared");
			ResultSet rs = ps.executeQuery();
			Log.info("R Select Query Executed");

			while (rs.next()) {
				reimbursements.add(new Reimbursement(rs.getInt("Reimburse_ID"),rs.getDouble("Amount_Requested"),rs.getString("Request_Author"),rs.getString("Request_Resolver"),rs.getTimestamp("Submission_Time"),rs.getTimestamp("Resolved_Time"),rs.getString("Request_Description"),rs.getInt("Approved_Status"),rs.getString("Request_Category")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimbursements;
	}

	
	
	@Override
	public int updateReimbursement(Reimbursement u) {
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			PreparedStatement ps = conn.prepareStatement("UPDATE Reimbursement_Table SET Amount_Requested=?, Request_Author=?, Request_Resolver=?, Submission_Time=?, Resolved_Time=?, Request_Description=?, Approved_Status=?, Request_Category=? WHERE Reimburse_ID=?");
			
			ps.setDouble(1, u.getAmount());
			ps.setString(2, u.getTicketAuthor());
			ps.setString(3, u.getTicketResolver());
			ps.setTimestamp(4, u.getSubmitTime());
			ps.setTimestamp(5, u.getResolvedTime());
			ps.setString(6, u.getDescription());
			ps.setInt(7, u.getStatus());
			ps.setString(8, u.getType());
			ps.setInt(9,u.getReimburseId());
			Log.info("R Update Query Prepared");
			ps.executeUpdate();
			Log.info("R Update Query Executed");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

		
//	@Override
//	public int deleteReimbursement(int id) {
//		try (Connection conn = DriverManager.getConnection(url, username, password)) {
//			PreparedStatement ps = conn.prepareStatement("DELETE FROM Reimbursements WHERE Reimburse_ID=?");
//			ps.setInt(1, id);
//			Log.info("R Delete Query Prepared");
//			ps.executeUpdate();
//			Log.info("R Delete Query Executed");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return 0;
//	}




}
