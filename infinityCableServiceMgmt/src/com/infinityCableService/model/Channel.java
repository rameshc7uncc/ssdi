package com.infinityCableService.model;

public class Channel {
	
	public Channel(){
		
	}
	
	public Channel(int c_Id, String c_Name, String c_Price, String c_Status, 
			String c_HD) {
		super();
		this.c_Id = c_Id;
		this.c_Name = c_Name;
		this.c_Price = c_Price;
		this.c_Status = c_Status;
		this.c_HD = c_HD;
	}
	
	private int c_Id;
	private String c_Name;
	
	private String c_Price;
	private String c_Status;
	private String c_HD;
	
	
	
	public long getc_Id() {
		return c_Id;
	}
	public void setc_Id(int c_Id) {
		this.c_Id = c_Id;
	}
	public String getc_Name() {
		return c_Name;
	}
	public void setc_Name(String c_Name) {
		this.c_Name = c_Name;
	}
	public String getc_Price() {
		return c_Price;
	}
	public void setc_Price(String c_Price) {
		this.c_Price = c_Price;
	}
	public String getc_Status() {
		return c_Status;
	}
	public void setc_Status(String c_Status) {
		this.c_Status = c_Status;
	}
	public String getc_HD() {
		return c_HD;
	}
	public void setc_HD(String c_HD) {
		this.c_HD = c_HD;
	}	
}
