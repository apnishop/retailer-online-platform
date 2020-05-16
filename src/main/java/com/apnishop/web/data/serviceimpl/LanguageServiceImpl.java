package com.apnishop.web.data.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apnishop.web.data.dao.LanguageDAO;
import com.apnishop.web.data.entity.Language;
import com.apnishop.web.service.LanguageService;

@Service
public class LanguageServiceImpl implements LanguageService{
	
	@Autowired
	 LanguageDAO langDAO;

	@Override
	public Language findbyLangName(String name) {
		// TODO Auto-generated method stub
		return langDAO.findByName(name);
	}

}
