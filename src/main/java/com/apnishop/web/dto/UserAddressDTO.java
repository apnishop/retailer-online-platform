package com.apnishop.web.dto;

import java.util.ArrayList;

import com.apnishop.web.data.entity.Address;

public class UserAddressDTO {
	
	String name;
	String emailid;
	String lang;
	String mobno;
	ArrayList<Address> addrList;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getMobno() {
		return mobno;
	}
	public void setMobno(String mobno) {
		this.mobno = mobno;
	}
	public ArrayList<Address> getAddrList() {
		return addrList;
	}
	public void setAddrList(ArrayList<Address> addrList) {
		this.addrList = addrList;
	}
	
	

}
