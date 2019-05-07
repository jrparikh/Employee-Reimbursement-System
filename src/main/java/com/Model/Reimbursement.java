package com.Model;

import java.sql.Timestamp;

public class Reimbursement {
	private Integer reimburseId = null;
	private double amount;	
	private String ticketAuthor;
	private String ticketResolver;
	private Timestamp submitTime;
	private Timestamp resolvedTime;
	private String description;
	private int status;
	private String type;

	
	//------------------------Constructors-----------------------------------------------------
	public Reimbursement() {
		
	}

	public Reimbursement( double amount, String ticketAuthor,
			 String description, int status,  String type) {
		this.amount = amount;
		this.ticketAuthor = ticketAuthor;//Set automatically
		this.description = description;
		this.status = status; //initialized at 0
		this.type = type;
	}	
	
	
	public Reimbursement(Integer reimburseId, double amount, String ticketAuthor, String ticketResolver,
			Timestamp submitTime, Timestamp resolvedTime, String description, int status, String type) {
		this.reimburseId = reimburseId;
		this.amount = amount;
		this.ticketAuthor = ticketAuthor;
		this.ticketResolver = ticketResolver;
		this.submitTime = submitTime;
		this.resolvedTime = resolvedTime;
		this.description = description;
		this.status = status;
		this.type = type;
	}

	//ToString
	@Override
	public String toString() {
		return "Reimbursement [reimburseId=" + reimburseId + ", amount=" + amount + ", ticketAuthor=" + ticketAuthor
				+ ", ticketResolver=" + ticketResolver + ", submitTime=" + submitTime + ", resolvedTime=" + resolvedTime
				+ ", description=" + description + ", status=" + status + ", type=" + type + "]";
	}

	
	
	//--------------------Getters and Setters---------------------------------------------------
	public Integer getReimburseId() {
		return reimburseId;
	}

	public void setReimburseId(Integer reimburseId) {
		this.reimburseId = reimburseId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getTicketAuthor() {
		return ticketAuthor;
	}

	public void setTicketAuthor(String ticketAuthor) {
		this.ticketAuthor = ticketAuthor;
	}

	public String getTicketResolver() {
		return ticketResolver;
	}

	public void setTicketResolver(String ticketResolver) {
		this.ticketResolver = ticketResolver;
	}

	public Timestamp getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(Timestamp submitTime) {
		this.submitTime = submitTime;
	}

	public Timestamp getResolvedTime() {
		return resolvedTime;
	}

	public void setResolvedTime(Timestamp resolvedTime) {
		this.resolvedTime = resolvedTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}		
}

