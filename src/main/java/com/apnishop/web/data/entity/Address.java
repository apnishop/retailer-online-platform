package com.apnishop.web.data.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="Id")
	private int id;
	
	//@Column(name="RetailerFullName")
	private String firstname;
	
	private String lastname;
	
	private String email;

	private String company;
	
	private int countryid;
	
	private int stateprovinceid;
		
	private String county;
	
	private String city;
	
	private String address1;
	
	private String address2;
	
	private String zippostalcode;
	
	private String phonenumber;
	
	private String faxnumber;
	
	private String landmark;
	
	private Timestamp createdonutc;
	
	private float gpslong;
	
	private float gpslat;
	
	private String gpsarea;
	
	private float gpsradius;
	
	private int userid;
	
	private String addresstype;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getCountryid() {
		return countryid;
	}

	public void setCountryid(int countryid) {
		this.countryid = countryid;
	}

	public int getStateprovinceid() {
		return stateprovinceid;
	}

	public void setStateprovinceid(int stateprovinceid) {
		this.stateprovinceid = stateprovinceid;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getZippostalcode() {
		return zippostalcode;
	}

	public void setZippostalcode(String zippostalcode) {
		this.zippostalcode = zippostalcode;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getFaxnumber() {
		return faxnumber;
	}

	public void setFaxnumber(String faxnumber) {
		this.faxnumber = faxnumber;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public Timestamp getCreatedonutc() {
		return createdonutc;
	}

	public void setCreatedonutc(Timestamp createdonutc) {
		this.createdonutc = createdonutc;
	}

	public float getGpslong() {
		return gpslong;
	}

	public void setGpslong(float gpslong) {
		this.gpslong = gpslong;
	}

	public float getGpslat() {
		return gpslat;
	}

	public void setGpslat(float gpslat) {
		this.gpslat = gpslat;
	}

	public String getGpsarea() {
		return gpsarea;
	}

	public void setGpsarea(String gpsarea) {
		this.gpsarea = gpsarea;
	}

	public float getGpsradius() {
		return gpsradius;
	}

	public void setGpsradius(float gpsradius) {
		this.gpsradius = gpsradius;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getAddresstype() {
		return addresstype;
	}

	public void setAddresstype(String addresstype) {
		this.addresstype = addresstype;
	}
	
	

}
