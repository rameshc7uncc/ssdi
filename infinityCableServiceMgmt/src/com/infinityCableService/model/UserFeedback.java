package com.infinityCableService.model;

public class UserFeedback {
	private int row_Id;
	private long u_Id;
	private String q_type;
	private String q_status;
	private String start_Date;
	private String end_Date;

public UserFeedback(){
		
	}
public UserFeedback(int c_id, String c_type, String c_Status,String s_date, String e_date) {
	super();
	//this.r_Id = c_Id;
	this.u_Id = c_id;
	this.q_type = c_type;
	this.q_status = c_Status;
	this.start_Date= s_date;
	this.end_Date= e_date;

}




public int getRow_Id() {
	return row_Id;
}
public void setRow_Id(int row_Id) {
	this.row_Id = row_Id;
}
public long getU_Id() {
	return u_Id;
}
public void setU_Id(long u_Id) {
	this.u_Id = u_Id;
}
public String getQ_type() {
	return q_type;
}
public void setQ_type(String q_type) {
	this.q_type = q_type;
}
public String getQ_status() {
	return q_status;
}
public void setQ_status(String q_status) {
	this.q_status = q_status;
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
