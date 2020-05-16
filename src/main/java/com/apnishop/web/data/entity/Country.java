package com.apnishop.web.data.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="Id")
	private int id;
	
	
	private String name;
	
	private String allowsbilling;
	
	private String allowsshipping;
	
	private String twoletterisocode;
	
	private String threeletterisocode;
	
	private int numericisocode;
	
	private int published;
	
	private int displayorder;

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

	public String getAllowsbilling() {
		return allowsbilling;
	}

	public void setAllowsbilling(String allowsbilling) {
		this.allowsbilling = allowsbilling;
	}

	public String getAllowsshipping() {
		return allowsshipping;
	}

	public void setAllowsshipping(String allowsshipping) {
		this.allowsshipping = allowsshipping;
	}

	public String getTwoletterisocode() {
		return twoletterisocode;
	}

	public void setTwoletterisocode(String twoletterisocode) {
		this.twoletterisocode = twoletterisocode;
	}

	public String getThreeletterisocode() {
		return threeletterisocode;
	}

	public void setThreeletterisocode(String threeletterisocode) {
		this.threeletterisocode = threeletterisocode;
	}

	public int getNumericisocode() {
		return numericisocode;
	}

	public void setNumericisocode(int numericisocode) {
		this.numericisocode = numericisocode;
	}

	public int getPublished() {
		return published;
	}

	public void setPublished(int published) {
		this.published = published;
	}

	public int getDisplayorder() {
		return displayorder;
	}

	public void setDisplayorder(int displayorder) {
		this.displayorder = displayorder;
	}
	
	
}
