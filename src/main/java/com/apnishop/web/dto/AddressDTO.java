package com.apnishop.web.dto;

import java.sql.Timestamp;

public class AddressDTO {
	
	private String addresstype;
	private String address1;
	private String city;
	private int stateprovinceid;
	private int countryid;
	private String landmark;
	private String zippostalcode;
	

	private Timestamp createdonutc;
	
	
	public Timestamp getCreatedonutc() {
		return createdonutc;
	}
	public void setCreatedonutc(Timestamp createdonutc) {
		this.createdonutc = createdonutc;
	}
	public String getAddresstype() {
		return addresstype;
	}
	public void setAddresstype(String addresstype) {
		this.addresstype = addresstype;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getStateprovinceid() {
		return stateprovinceid;
	}
	public void setStateprovinceid(int stateprovinceid) {
		this.stateprovinceid = stateprovinceid;
	}
	
	public int getCountryid() {
		return countryid;
	}
	public void setCountryid(int countryid) {
		this.countryid = countryid;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getZippostalcode() {
		return zippostalcode;
	}
	public void setZippostalcode(String zippostalcode) {
		this.zippostalcode = zippostalcode;
	}
		

}
