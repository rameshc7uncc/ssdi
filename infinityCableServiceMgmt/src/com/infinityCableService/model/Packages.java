package com.infinityCableService.model;

public class Packages {
	
	public Packages(){
		
	}
	
	public Packages(int p_Id, String p_Name,
			String p_Description, double p_Price, String p_Status, 
			String p_CreatedDate,
			String p_DeletedDate) {
		super();
		this.p_Id = p_Id;
		this.p_Name = p_Name;
		this.p_Description = p_Description;
		this.p_Price = p_Price;
		this.p_Status = p_Status;
		this.p_CreatedDate = p_CreatedDate;
		this.p_DeletedDate = p_DeletedDate;
	}
	
	private int p_Id;
	private String p_Name;
	private String p_Description;
	private double p_Price;
	private String p_Status;
	private String p_CreatedDate;
	private String p_DeletedDate;
	
	
	
	public int getp_Id() {
		return p_Id;
	}
	public void setp_Id(int p_Id) {
		this.p_Id = p_Id;
	}
	public String getp_Name() {
		return p_Name;
	}
	public void setp_Name(String p_Name) {
		this.p_Name = p_Name;
	}
	public String getp_Description() {
		return p_Description;
	}
	public void setp_Description(String p_Description) {
		this.p_Description = p_Description;
	}
	public double getp_Price() {
		return p_Price;
	}
	public void setp_Price(double p_Price) {
		this.p_Price = p_Price;
	}
	public String getp_Status() {
		return p_Status;
	}
	public void setp_Status(String p_Status) {
		this.p_Status = p_Status;
	}
	public String getp_CreatedDate() {
		return p_CreatedDate;
	}
	public void setp_CreatedDate(String p_CreatedDate) {
		this.p_CreatedDate = p_CreatedDate;
	}
	public String getp_DeletedDate() {
		return p_DeletedDate;
	}
	public void setp_DeletedDate(String p_DeletedDate) {
		this.p_DeletedDate = p_DeletedDate;
	}	
}
