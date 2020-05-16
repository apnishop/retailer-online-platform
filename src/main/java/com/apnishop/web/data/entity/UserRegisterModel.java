package com.apnishop.web.data.entity;

import java.util.List;

public class UserRegisterModel {
	
	public User userobj;
	public List<Retailer> retObj;
	public User getUserobj() {
		return userobj;
	}
	public void setUserobj(User userobj) {
		this.userobj = userobj;
	}
	public List<Retailer> getRetObj() {
		return retObj;
	}
	public void setRetObj(List<Retailer> retObj) {
		this.retObj = retObj;
	}
	
	

}
