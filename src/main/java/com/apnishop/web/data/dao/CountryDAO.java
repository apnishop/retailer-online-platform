package com.apnishop.web.data.dao;

import org.springframework.data.repository.CrudRepository;

import com.apnishop.web.data.entity.Country;

public interface CountryDAO extends CrudRepository<Country, Long>{

	public Country findByName(String name);

}
