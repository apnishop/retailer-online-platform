package com.apnishop.web.data.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	
	//@Column(name="UserGuid")
	private String userguid;

	//@Column(name="UserName")
	private String username;
	
	//@Column(name="UserMobileNo")
	private String usermobileno;
	
	//@Column(name="UserRole")
	private String userrole;
	
	private String usertype;
	
	//@Column(name="Email")
	private String email;
	
	
	private String emailtorevalidate;
	
	
	private String admincomment;
	
	
	private int istaxexempt;
	
	
	private int affiliateid;
	
		
	private int hasshoppingcartitems;
	
	//@Column(name="RequireReLogin")
	private int requirerelogin;
	
	//@Column(name="FailedLoginAttempts")
	private int failedloginattempts;
	
	//@Column(name="CannotLoginUntilDateUtc")
	private Timestamp cannotloginuntildateutc;
	
	//@Column(name="Active")
	private int active;
	
	//@Column(name="Deleted")
	private int deleted;
	
	//@Column(name="IsSystemAccount")
	private int issystemaccount;
	
	//@Column(name="SystemName")
	private String systemname;
	
	//@Column(name="LastIpAddress")
	private String lastipaddress;
	
	//@Column(name="CreatedOnUtc")
	private Timestamp createdonutc;
	
	//@Column(name="LastloginDateUtc")
	private Timestamp lastlogindateutc;
	
	//@Column(name="LastActivityDateUtc")
	private Timestamp lastactivitydateutc;
		
	//@Column(name="LanguageId")
	private int languageid;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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


	public String getLastipaddress() {
		return lastipaddress;
	}

	public void setLastipaddress(String lastipaddress) {
		this.lastipaddress = lastipaddress;
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

	public String getUsermobileno() {
		return usermobileno;
	}

	public void setUsermobileno(String usermobileno) {
		this.usermobileno = usermobileno;
	}

	public int getIssystemaccount() {
		return issystemaccount;
	}

	public void setIssystemaccount(int issystemaccount) {
		this.issystemaccount = issystemaccount;
	}

	public String getSystemname() {
		return systemname;
	}

	public void setSystemname(String systemname) {
		this.systemname = systemname;
	}

	public String getUsertype() {
		return usertype;
	}

	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	
	
	
}
