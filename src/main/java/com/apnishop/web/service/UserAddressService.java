package com.apnishop.web.service;

import com.apnishop.web.data.entity.Address;
import com.apnishop.web.data.entity.User;

public interface UserAddressService {
	
	public void updateUserAddress(User uObj,Address addrObj,String lang,String state,String Country);
	//public void updateUserRetailer_Retailer(User uObj,Retailer retObj);


}
