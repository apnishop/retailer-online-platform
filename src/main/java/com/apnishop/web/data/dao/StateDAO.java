package com.apnishop.web.data.dao;

import org.springframework.data.repository.CrudRepository;

import com.apnishop.web.data.entity.State;

public interface StateDAO extends CrudRepository<State, Long>{

	public State findByName(String name);

}
