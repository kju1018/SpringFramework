package com.mycompany.webapp.dto;

import java.util.Date;

public class Order {
	private int orderNo;
	private String uid;
	private String oAddress;
	private String oReceiver;
	private int oNumber;
	private String oMessage;
	private String oMethod;
	private Date oDate;
	private String oState;
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getoAddress() {
		return oAddress;
	}
	public void setoAddress(String oAddress) {
		this.oAddress = oAddress;
	}
	public String getoReceiver() {
		return oReceiver;
	}
	public void setoReceiver(String oReceiver) {
		this.oReceiver = oReceiver;
	}
	public int getoNumber() {
		return oNumber;
	}
	public void setoNumber(int oNumber) {
		this.oNumber = oNumber;
	}
	public String getoMessage() {
		return oMessage;
	}
	public void setoMessage(String oMessage) {
		this.oMessage = oMessage;
	}
	public String getoMethod() {
		return oMethod;
	}
	public void setoMethod(String oMethod) {
		this.oMethod = oMethod;
	}
	public Date getoDate() {
		return oDate;
	}
	public void setoDate(Date oDate) {
		this.oDate = oDate;
	}
	public String getoState() {
		return oState;
	}
	public void setoState(String oState) {
		this.oState = oState;
	}
	
	
}
