package com.apnishop.web.data.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.apnishop.web.data.dao.UserDAO;
import com.apnishop.web.data.entity.User;
import com.apnishop.web.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	 UserDAO userDAO;
	
	@Autowired
	 UserServiceImpl _userService;
	
	
	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserbyuname(String uname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUser(User user) {
		userDAO.save(user);
	}

	

	@Override
	public void delUser(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> listUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByMobNo(String mob) {
		// TODO Auto-generated method stub
		return userDAO.findByUsermobileno(mob);
	}

	@Override
	public void updateUser(String type, String role,int userid) {
		userDAO.updateUser(type, role, userid);
		
	}

	@Override
	public void updateUserProfile(String name, String mail, int langid, int userid) {
		userDAO.updateUserProfile(name, mail, langid, userid);
		
	}

}
