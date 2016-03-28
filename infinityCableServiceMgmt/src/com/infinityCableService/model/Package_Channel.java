package com.infinityCableService.model;

public class Package_Channel {
	
	
	public Package_Channel(){
		
	}
	
	public Package_Channel(int row_Id, int c_Id, int p_Id) {
		super();
		this.row_Id = row_Id;
		this.c_Id = c_Id;
		this.p_Id = p_Id;
	}
	
	private int row_Id;
	private int c_Id;
	private int p_Id;
	
	public int getRow_id() {
		return row_Id;
	}

	public void setRow_id(int row_id) {
		this.row_Id = row_id;
	}

	
	public int getc_Id() {
		return c_Id;
	}
	public void setc_Id(int c_Id) {
		this.c_Id = c_Id;
	}
	public int getp_Id() {
		return p_Id;
	}
	public void setp_Id(int p_Id) {
		this.p_Id = p_Id;
	}
		
}
