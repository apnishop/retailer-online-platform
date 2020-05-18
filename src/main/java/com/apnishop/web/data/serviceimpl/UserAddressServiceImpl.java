package com.apnishop.web.data.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apnishop.web.data.entity.Address;
import com.apnishop.web.data.entity.Country;
import com.apnishop.web.data.entity.Language;
import com.apnishop.web.data.entity.State;
import com.apnishop.web.data.entity.User;
import com.apnishop.web.service.AddressService;
import com.apnishop.web.service.CountryService;
import com.apnishop.web.service.LanguageService;
import com.apnishop.web.service.StateService;
import com.apnishop.web.service.UserAddressService;
import com.apnishop.web.service.UserService;

import ch.qos.logback.classic.Logger;

@Service
public class UserAddressServiceImpl implements UserAddressService{

	@Autowired
	 UserService userservice;
	
	@Autowired
	 AddressService addrservice;
	
	@Autowired
	 StateService stateservice;
	
	@Autowired
	 LanguageService langservice;
	
	@Autowired
	 CountryService ctservice;
	
	@Override
	@Transactional
	public void updateUserAddress(User uObj, Address addrObj,int ct) {
		if(ct==0)
		{//only 1 address in the request
			
		userservice.updateUserProfile(uObj.getUsername(), uObj.getEmail(),uObj.getLanguageid(), uObj.getUserguid());
		addrservice.addAddress(addrObj);
		}
		else if(ct==-1)
		{//if there is no address in the request
			
			userservice.updateUserProfile(uObj.getUsername(), uObj.getEmail(),uObj.getLanguageid(), uObj.getUserguid());
			
		}
		else{// more than 1 address present
			
			addrservice.addAddress(addrObj);
		}
		
		
	}

}
