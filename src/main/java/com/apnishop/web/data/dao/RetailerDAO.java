package com.apnishop.web.data.dao;

import org.springframework.data.repository.CrudRepository;

import com.apnishop.web.data.entity.Retailer;


public interface RetailerDAO extends CrudRepository<Retailer, Long>{
	
	public Retailer findByStoreid(String storeid);
	public Retailer findByStorename(String name);

}
