package com.apnishop.web.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.apnishop.web.data.entity.Retailer;

@Transactional
public interface RetailerService {
	
	public Retailer getByStoreId(String storeid);
	public Retailer getByStorename(String storename);
	public List<Retailer> getAllStores();
	public void addRetailer(Retailer store);

}
