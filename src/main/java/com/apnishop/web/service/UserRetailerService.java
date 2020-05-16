package com.apnishop.web.service;

import com.apnishop.web.data.entity.Retailer;
import com.apnishop.web.data.entity.User;
import com.apnishop.web.data.entity.UserRetailerMapping;

public interface UserRetailerService {
	
	public void updateUserRetailer_Customer(User uObj,UserRetailerMapping URetObj);
	public void updateUserRetailer_Retailer(User uObj,Retailer retObj);

}
