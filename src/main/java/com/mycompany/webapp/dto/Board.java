package com.mycompany.webapp.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Board {
	private int bno;
	private String bTitle;
	private String bContent;
	private String bWriter;
	private Date bdate;
	private int bhitcount;
	private MultipartFile battach;
	private String battachoname;
	private String battachsname;
	private String battachtype;
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getBtitle() {
		return bTitle;
	}
	public void setBtitle(String btitle) {
		this.bTitle = btitle;
	}
	public String getBcontent() {
		return bContent;
	}
	public void setBcontent(String bcontent) {
		this.bContent = bcontent;
	}
	public String getBwriter() {
		return bWriter;
	}
	public void setBwriter(String bwriter) {
		this.bWriter = bwriter;
	}
	public Date getBdate() {
		return bdate;
	}
	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}
	public int getBhitcount() {
		return bhitcount;
	}
	public void setBhitcount(int bhitcount) {
		this.bhitcount = bhitcount;
	}
	public String getBattachoname() {
		return battachoname;
	}
	public void setBattachoname(String battachoname) {
		this.battachoname = battachoname;
	}
	public String getBattachsname() {
		return battachsname;
	}
	public void setBattachsname(String battachsname) {
		this.battachsname = battachsname;
	}
	public String getBattachtype() {
		return battachtype;
	}
	public void setBattachtype(String battachtype) {
		this.battachtype = battachtype;
	}
	public MultipartFile getBattach() {
		return battach;
	}
	public void setBattach(MultipartFile battach) {
		this.battach = battach;
	}
	
	
}
