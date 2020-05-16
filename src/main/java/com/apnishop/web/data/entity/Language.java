package com.apnishop.web.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "language")
public class Language {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="Id")
	private int id;
	
	//@Column(name="RetailerFullName")
	private String name;
	
	private String languageculture;
	
	private String uniqueseocode;

	private String flagimagefilename;
	
	private int rtl;
	
	private int limitedtostores;
	
	private int defaultcurrencyid;
	
	private String published;

	private String displayorder;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLanguageculture() {
		return languageculture;
	}

	public void setLanguageculture(String languageculture) {
		this.languageculture = languageculture;
	}

	public String getUniqueseocode() {
		return uniqueseocode;
	}

	public void setUniqueseocode(String uniqueseocode) {
		this.uniqueseocode = uniqueseocode;
	}

	public String getFlagimagefilename() {
		return flagimagefilename;
	}

	public void setFlagimagefilename(String flagimagefilename) {
		this.flagimagefilename = flagimagefilename;
	}

	public int getRtl() {
		return rtl;
	}

	public void setRtl(int rtl) {
		this.rtl = rtl;
	}

	public int getLimitedtostores() {
		return limitedtostores;
	}

	public void setLimitedtostores(int limitedtostores) {
		this.limitedtostores = limitedtostores;
	}

	public int getDefaultcurrencyid() {
		return defaultcurrencyid;
	}

	public void setDefaultcurrencyid(int defaultcurrencyid) {
		this.defaultcurrencyid = defaultcurrencyid;
	}

	public String getPublished() {
		return published;
	}

	public void setPublished(String published) {
		this.published = published;
	}

	public String getDisplayorder() {
		return displayorder;
	}

	public void setDisplayorder(String displayorder) {
		this.displayorder = displayorder;
	}
	
	

}
