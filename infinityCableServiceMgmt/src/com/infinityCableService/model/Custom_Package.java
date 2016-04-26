package com.infinityCableService.model;

public class Custom_Package {
	int user_Id;
	int p_Id;
	int c_Id; 
	int row_Id;


	public Custom_Package(){
		
	}
public Custom_Package(int user_Id, int p_Id, int c_Id) {
	super();
	this.user_Id = user_Id;
	this.p_Id = p_Id;
	this.c_Id = c_Id;

}

public int getuser_Id() {
	return user_Id;
}
public void setuser_Id(int user_Id) {
	this.user_Id = user_Id;
}
public int getp_Id() {
	return p_Id;
}
public void setp_Id(int p_Id) {
	this.p_Id = p_Id;
}
public int getc_Id() {
	return c_Id;
}
public void setc_Id(int c_Id) {
	this.c_Id = c_Id;
}

public int getRow_Id() {
	return row_Id;
}
public void setRow_Id(int row_Id) {
	this.row_Id = row_Id;
}
}
