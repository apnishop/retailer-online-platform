package com.apnishop.web.data.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apnishop.web.data.entity.Retailer;
import com.apnishop.web.data.entity.User;
import com.apnishop.web.data.entity.UserRetailerMapping;
import com.apnishop.web.service.RetailerService;
import com.apnishop.web.service.UserRetailerMappingService;
import com.apnishop.web.service.UserRetailerService;
import com.apnishop.web.service.UserService;

@Service
public class UserRetailerServiceImpl implements UserRetailerService{
	
	/*
	 * This service is written so that transactions management of user and retailer
	 * can be handled from the controller
	 */

	@Autowired
	 UserService userservice;
	
	@Autowired
	 UserRetailerMappingService userretservice;
	
	@Autowired
	 RetailerService retservice;
	

	@Override
	@Transactional
	public void updateUserRetailer_Customer(User uObj, UserRetailerMapping URetObj) {
		userservice.updateUser(uObj.getUsertype(), uObj.getUserrole(), uObj.getId());
		userretservice.addUserRet(URetObj);
		
	}


	@Override
	@Transactional
	public void updateUserRetailer_Retailer(User uObj, Retailer retObj) {
		userservice.updateUser(uObj.getUsertype(), uObj.getUserrole(), uObj.getId());
		retservice.addRetailer(retObj);
	}




}
