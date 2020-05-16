package com.apnishop.web.data.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apnishop.web.data.dao.CountryDAO;
import com.apnishop.web.data.entity.Country;
import com.apnishop.web.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService{
	
	@Autowired
	 CountryDAO ctDAO;

	@Override
	public Country findbyCtName(String name) {
		// TODO Auto-generated method stub
		return ctDAO.findByName(name);
	}

}
