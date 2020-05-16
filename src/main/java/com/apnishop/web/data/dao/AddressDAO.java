package com.apnishop.web.data.dao;

import org.springframework.data.repository.CrudRepository;

import com.apnishop.web.data.entity.Address;

public interface AddressDAO extends CrudRepository<Address, Long>{

}
