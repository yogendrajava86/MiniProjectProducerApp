package com.app.model;

public class CardInfo {

	private String txId;
	private String cname;
	private String cnum;
	private int cvv;
	private String expDate;
	private double amt;
	public CardInfo() {
		super();
	}
	public CardInfo(String txId, String cname, String cnum, int cvv, String expDate, double amt) {
		super();
		this.txId = txId;
		this.cname = cname;
		this.cnum = cnum;
		this.cvv = cvv;
		this.expDate = expDate;
		this.amt = amt;
	}
	public String getTxId() {
		return txId;
	}
	public void setTxId(String txId) {
		this.txId = txId;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCnum() {
		return cnum;
	}
	public void setCnum(String cnum) {
		this.cnum = cnum;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public double getAmt() {
		return amt;
	}
	public void setAmt(double amt) {
		this.amt = amt;
	}
	@Override
	public String toString() {
		return "CardInfo [txId=" + txId + ", cname=" + cname + ", cnum=" + cnum + ", cvv=" + cvv + ", expDate="
				+ expDate + ", amt=" + amt + "]";
	}
	
}
