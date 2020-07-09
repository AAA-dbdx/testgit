package com.neuedu.homework01;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DakaInfo {

	private int iD;
	private Date inDate=null;
	private Date offDate=null;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS");
	
	public DakaInfo(int iD) {
		this.iD = iD;
	}

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}
	
	public Date getInDate() {
		return inDate;
	}

	public Date getOffDate() {
		return offDate;
	}

	public String getInDateFormat() {
		String in = sdf.format(this.inDate);
		return in;
	}

	public String getOffDateFormat() {
		String off = sdf.format(this.offDate);
		return off;
	}

	public void setInDate() {
		this.inDate = new Date();
	}

	public void setOffDate() {
		this.offDate = new Date();
	}
	
	
}
