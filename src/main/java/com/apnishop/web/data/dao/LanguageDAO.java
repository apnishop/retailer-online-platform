package com.apnishop.web.data.dao;

import org.springframework.data.repository.CrudRepository;

import com.apnishop.web.data.entity.Language;

public interface LanguageDAO extends CrudRepository<Language, Long>{
	
	public Language findByName(String name);

}
