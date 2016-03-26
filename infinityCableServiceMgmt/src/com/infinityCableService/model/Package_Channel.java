package com.infinityCableService.model;

public class Package_Channel {
	
	public Package_Channel(){
		
	}
	
	public Package_Channel(int c_Id, int p_Id) {
		super();
		this.c_Id = c_Id;
		this.p_Id = p_Id;
	}
	
	private int c_Id;
	private int p_Id;
	
	public long getc_Id() {
		return c_Id;
	}
	public void setc_Id(int c_Id) {
		this.c_Id = c_Id;
	}
	public long getp_Id() {
		return p_Id;
	}
	public void setp_Id(int p_Id) {
		this.p_Id = p_Id;
	}
		
}
