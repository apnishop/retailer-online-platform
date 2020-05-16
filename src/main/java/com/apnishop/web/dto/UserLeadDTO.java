package com.apnishop.web.dto;

import java.sql.Timestamp;


public class UserLeadDTO {
	
	
	private String userguid;
	
	private String usermobileno;

	private String usertype;

	private Timestamp createdonutc;
	
	private Timestamp lastactivitydateutc;

	
	

	public String getUsermobileno() {
		return usermobileno;
	}

	public void setUsermobileno(String usermobileno) {
		this.usermobileno = usermobileno;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	public Timestamp getCreatedonutc() {
		return createdonutc;
	}

	public void setCreatedonutc(Timestamp createdonutc) {
		this.createdonutc = createdonutc;
	}

	public Timestamp getLastactivitydateutc() {
		return lastactivitydateutc;
	}

	public void setLastactivitydateutc(Timestamp lastactivitydateutc) {
		this.lastactivitydateutc = lastactivitydateutc;
	}

	public String getUserguid() {
		return userguid;
	}

	public void setUserguid(String userguid) {
		this.userguid = userguid;
	}
	
	

}
