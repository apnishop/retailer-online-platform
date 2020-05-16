package com.apnishop.web.data.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apnishop.web.data.dao.StateDAO;
import com.apnishop.web.data.entity.State;
import com.apnishop.web.service.StateService;

@Service
public class StateServiceImpl implements StateService{
	
	@Autowired
	 StateDAO stateDAO;

	@Override
	public State findbyStateName(String name) {
		// TODO Auto-generated method stub
		return stateDAO.findByName(name);
	}

}
