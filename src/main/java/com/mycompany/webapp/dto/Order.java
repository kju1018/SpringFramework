package com.mycompany.webapp.dto;

import java.util.Arrays;
import java.util.Date;

public class Order {
	private int orderNo;
	private String uid;
	private String oAddress;
	private String oReceiver;
	private String oNumber;
	private String oMessage;
	private String oMethod;
	private Date oDate;
	private String oState;
	private int oZipcode;
	private String oAccountInfo;
	private String oDepositor;
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
	public String getoNumber() {
		return oNumber;
	}
	public void setoNumber(String oNumber) {
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
	public int getoZipcode() {
		return oZipcode;
	}
	public void setoZipcode(int oZipcode) {
		this.oZipcode = oZipcode;
	}
	public String getoAccountInfo() {
		return oAccountInfo;
	}
	public void setoAccountInfo(String oAccountInfo) {
		this.oAccountInfo = oAccountInfo;
	}
	public String getoDepositor() {
		return oDepositor;
	}
	public void setoDepositor(String oDepositor) {
		this.oDepositor = oDepositor;
	}
	@Override
	public String toString() {
		return "Order [orderNo=" + orderNo + ", uid=" + uid + ", oAddress=" + oAddress + ", oReceiver=" + oReceiver
				+ ", oNumber=" + oNumber + ", oMessage=" + oMessage + ", oMethod=" + oMethod + ", oDate=" + oDate
				+ ", oState=" + oState + ", oZipcode=" + oZipcode + ", oAccountInfo=" + oAccountInfo + ", oDepositor="
				+ oDepositor + "]";
	}
	
	
	
	
	
}
