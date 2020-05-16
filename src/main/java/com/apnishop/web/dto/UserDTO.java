package com.apnishop.web.dto;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
public class UserDTO {
	
	
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String userguid;

	
	private String username;
	
	
	private String usermobileno;
	
	private String usertype;
	
	
	private String userrole;
	
	
	private String email;
	
	
	private String emailtorevalidate;
	
	
	private String admincomment;
	
	
	private int istaxexempt;
	
	
	private int affiliateid;
	
	
	private int retailerid;
	
	
	private int hasshoppingcartitems;
	
	
	private int requirerelogin;
	
	
	private int failedloginattempts;
	
	
	private Timestamp cannotloginuntildateutc;
	
	
	private int active;
	
	
	private int deleted;
	
	
	private int issysacc;
	
	
	private String sysname;
	
	
	private String lastipaddr;
	
	
	private Timestamp createdonutc;
	
	
	private Timestamp lastlogindateutc;
	
	
	private Timestamp lastactivitydateutc;
	
	
	private int registeredinstoreid;
	
	
	private int billingaddressid;
	
	
	private int shippingaddressid;
	
	
	private int languageid;

	

	public String getUserguid() {
		return userguid;
	}

	public void setUserguid(String userguid) {
		this.userguid = userguid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsermobileno() {
		return usermobileno;
	}

	public void setUsermobileno(String usermobileno) {
		this.usermobileno = usermobileno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmailtorevalidate() {
		return emailtorevalidate;
	}

	public void setEmailtorevalidate(String emailtorevalidate) {
		this.emailtorevalidate = emailtorevalidate;
	}

	public String getAdmincomment() {
		return admincomment;
	}

	public void setAdmincomment(String admincomment) {
		this.admincomment = admincomment;
	}

	public int getIstaxexempt() {
		return istaxexempt;
	}

	public void setIstaxexempt(int istaxexempt) {
		this.istaxexempt = istaxexempt;
	}

	public int getAffiliateid() {
		return affiliateid;
	}

	public void setAffiliateid(int affiliateid) {
		this.affiliateid = affiliateid;
	}

	public int getRetailerid() {
		return retailerid;
	}

	public void setRetailerid(int retailerid) {
		this.retailerid = retailerid;
	}

	public int getHasshoppingcartitems() {
		return hasshoppingcartitems;
	}

	public void setHasshoppingcartitems(int hasshoppingcartitems) {
		this.hasshoppingcartitems = hasshoppingcartitems;
	}

	public int getRequirerelogin() {
		return requirerelogin;
	}

	public void setRequirerelogin(int requirerelogin) {
		this.requirerelogin = requirerelogin;
	}

	public int getFailedloginattempts() {
		return failedloginattempts;
	}

	public void setFailedloginattempts(int failedloginattempts) {
		this.failedloginattempts = failedloginattempts;
	}

	public Timestamp getCannotloginuntildateutc() {
		return cannotloginuntildateutc;
	}

	public void setCannotloginuntildateutc(Timestamp cannotloginuntildateutc) {
		this.cannotloginuntildateutc = cannotloginuntildateutc;
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

	public int getIssysacc() {
		return issysacc;
	}

	public void setIssysacc(int issysacc) {
		this.issysacc = issysacc;
	}

	public String getSysname() {
		return sysname;
	}

	public void setSysname(String sysname) {
		this.sysname = sysname;
	}

	public String getLastipaddr() {
		return lastipaddr;
	}

	public void setLastipaddr(String lastipaddr) {
		this.lastipaddr = lastipaddr;
	}

	public Timestamp getCreatedonutc() {
		return createdonutc;
	}

	public void setCreatedonutc(Timestamp createdonutc) {
		this.createdonutc = createdonutc;
	}

	public Timestamp getLastlogindateutc() {
		return lastlogindateutc;
	}

	public void setLastlogindateutc(Timestamp lastlogindateutc) {
		this.lastlogindateutc = lastlogindateutc;
	}

	public Timestamp getLastactivitydateutc() {
		return lastactivitydateutc;
	}

	public void setLastactivitydateutc(Timestamp lastactivitydateutc) {
		this.lastactivitydateutc = lastactivitydateutc;
	}

	public int getRegisteredinstoreid() {
		return registeredinstoreid;
	}

	public void setRegisteredinstoreid(int registeredinstoreid) {
		this.registeredinstoreid = registeredinstoreid;
	}

	public int getBillingaddressid() {
		return billingaddressid;
	}

	public void setBillingaddressid(int billingaddressid) {
		this.billingaddressid = billingaddressid;
	}

	public int getShippingaddressid() {
		return shippingaddressid;
	}

	public void setShippingaddressid(int shippingaddressid) {
		this.shippingaddressid = shippingaddressid;
	}

	public String getUserrole() {
		return userrole;
	}

	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}

	public int getLanguageid() {
		return languageid;
	}

	public void setLanguageid(int languageid) {
		this.languageid = languageid;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	


}
