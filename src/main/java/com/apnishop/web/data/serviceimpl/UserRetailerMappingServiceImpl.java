package com.apnishop.web.data.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apnishop.web.data.dao.UserRetailerMappingDAO;
import com.apnishop.web.data.entity.UserRetailerMapping;
import com.apnishop.web.service.UserRetailerMappingService;

@Service
@Transactional
public class UserRetailerMappingServiceImpl implements UserRetailerMappingService{
	
	@Autowired
	 UserRetailerMappingDAO retDAO;

	@Override
	@Transactional
	public void addUserRet(UserRetailerMapping user) {
		retDAO.save(user);
	}

}
