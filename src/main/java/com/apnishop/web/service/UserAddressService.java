package com.apnishop.web.service;

import com.apnishop.web.data.entity.Address;
import com.apnishop.web.data.entity.User;

public interface UserAddressService {
	
	public void updateUserAddress(User uObj,Address addrObj,int size);
	//public void updateUserRetailer_Retailer(User uObj,Retailer retObj);


}
