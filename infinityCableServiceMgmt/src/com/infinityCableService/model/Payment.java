package com.infinityCableService.model;

public class Payment {

	public Payment() {

	}

	public Payment(long user_Id, String billing_Date, double bill_Amount, String payment_Date, String payment_Status) {
		super();
		this.user_Id = user_Id;
		this.billing_Date = billing_Date;
		this.bill_Amount = bill_Amount;
		this.payment_Date = payment_Date;
		this.payment_Status = payment_Status;
	}

	private int row_Id;
	private long user_Id;
	private double bill_Amount;
	private String payment_Status;
	private String payment_Date;
	private String billing_Date;

	public long getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(long user_Id) {
		this.user_Id = user_Id;
	}

	public double getbill_Amount() {
		return bill_Amount;
	}

	public void setbill_Amount(double bill_Amount) {
		this.bill_Amount = bill_Amount;
	}

	public String getpayment_Status() {
		return payment_Status;
	}

	public void setpayment_Status(String payment_Status) {
		this.payment_Status = payment_Status;
	}

	public String getpayment_Date() {
		return payment_Date;
	}

	public void setpayment_Date(String payment_Date) {
		this.payment_Date = payment_Date;
	}

	public String getbilling_Date() {
		return billing_Date;
	}

	public void setbilling_Date(String billing_Date) {
		this.billing_Date = billing_Date;
	}

	public int getRow_Id() {
		return row_Id;
	}

	public void setRow_Id(int row_Id) {
		this.row_Id = row_Id;
	}

}
