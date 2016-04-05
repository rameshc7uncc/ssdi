package com.infinityCableService.model;

public class Customer_Subscription {
	
	public Customer_Subscription() {

	}
	
	public Customer_Subscription(int row_Id, long user_Id, int p_Id, String start_Date, String end_Date) {
		super();
		this.setRow_Id(row_Id);
		this.setUser_Id(user_Id);
		this.setP_Id(p_Id);
		this.setStart_Date(start_Date);
		this.setEnd_Date(end_Date);
	}
	
	
	private int row_Id;
	private long user_Id;
	private int p_Id;
	private String start_Date;
	private String end_Date; 
	
	public int getRow_Id() {
		return row_Id;
	}

	public void setRow_Id(int row_Id) {
		this.row_Id = row_Id;
	}

	public long getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(long user_Id) {
		this.user_Id = user_Id;
	}

	public int getP_Id() {
		return p_Id;
	}

	public void setP_Id(int p_Id) {
		this.p_Id = p_Id;
	}

	public String getStart_Date() {
		return start_Date;
	}

	public void setStart_Date(String start_Date) {
		this.start_Date = start_Date;
	}

	public String getEnd_Date() {
		return end_Date;
	}

	public void setEnd_Date(String end_Date) {
		this.end_Date = end_Date;
	}


}
