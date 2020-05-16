package com.apnishop.web.data.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apnishop.web.data.dao.AddressDAO;
import com.apnishop.web.data.entity.Address;
import com.apnishop.web.service.AddressService;

@Service
public class AddressServiceImpl implements AddressService{

	
	@Autowired
	 AddressDAO addrDAO;
	
	@Override
	public void addAddress(Address addr) {
		addrDAO.save(addr);
	}

}
