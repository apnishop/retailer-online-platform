package com.apnishop.web.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "retailer")
public class Retailer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="Id")
	private int id;
	
	//@Column(name="RetailerFullName")
	private String storename;

	
	private String storeid;
	
	
	private String description;
	
	
	private int pictureid;
	
	//@Column(name="AdminComment")
	private String admincomment;
	
	//@Column(name="Active")
	private int active;
	
	//@Column(name="Deleted")
	private int deleted;
	
	
	private int displayorder;
	
	//@Column(name="MetaKeywords")
	private String metakeywords;
	
	//@Column(name="MetaDescription")
	private String metadescription;
	
//	@Column(name="MetaTitle")
	private String metatitle;
	
	private int userid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPictureid() {
		return pictureid;
	}

	public void setPictureid(int pictureid) {
		this.pictureid = pictureid;
	}

	public String getAdmincomment() {
		return admincomment;
	}

	public void setAdmincomment(String admincomment) {
		this.admincomment = admincomment;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public int getDisplayorder() {
		return displayorder;
	}

	public void setDisplayorder(int displayorder) {
		this.displayorder = displayorder;
	}

	public String getMetakeywords() {
		return metakeywords;
	}

	public void setMetakeywords(String metakeywords) {
		this.metakeywords = metakeywords;
	}

	public String getMetadescription() {
		return metadescription;
	}

	public void setMetadescription(String metadescription) {
		this.metadescription = metadescription;
	}

	public String getMetatitle() {
		return metatitle;
	}

	public void setMetatitle(String metatitle) {
		this.metatitle = metatitle;
	}

	public String getStorename() {
		return storename;
	}

	public void setStorename(String storename) {
		this.storename = storename;
	}

	public String getStoreid() {
		return storeid;
	}

	public void setStoreid(String storeid) {
		this.storeid = storeid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	
}
