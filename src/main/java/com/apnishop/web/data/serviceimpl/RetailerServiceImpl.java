package com.apnishop.web.data.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apnishop.web.data.dao.RetailerDAO;
import com.apnishop.web.data.entity.Retailer;
import com.apnishop.web.service.RetailerService;

@Service
@Transactional
public class RetailerServiceImpl implements RetailerService{
	
	@Autowired
	 RetailerDAO retDAO;

	@Override
	public Retailer getByStoreId(String storeid) {
		
		return retDAO.findByStoreid(storeid);
	}

	@Override
	public List<Retailer> getAllStores() {
		// TODO Auto-generated method stub
		return (List<Retailer>) retDAO.findAll();
	}

	@Override
	public void addRetailer(Retailer store) {
		retDAO.save(store);
	}

	@Override
	public Retailer getByStorename(String storename) {
		// TODO Auto-generated method stub
		return retDAO.findByStorename(storename);
	}

}
