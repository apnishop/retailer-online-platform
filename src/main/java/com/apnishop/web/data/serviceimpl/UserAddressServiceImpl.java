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
	public void updateUserAddress(User uObj, Address addrObj,String lang,String state, String country) {
		State sObj=stateservice.findbyStateName(state);
		Language lObj=langservice.findbyLangName(lang);
		System.out.print(country);
		Country cObj=ctservice.findbyCtName(country);
		System.out.print(country);
		uObj.setLanguageid(lObj.getId());
		addrObj.setCountryid(cObj.getId());
		addrObj.setStateprovinceid(sObj.getId());
		System.out.print(country);
		userservice.updateUserProfile(uObj.getUsername(), uObj.getEmail(),uObj.getLanguageid(), uObj.getId());
		addrservice.addAddress(addrObj);
		
	}

}
