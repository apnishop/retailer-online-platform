package com.apnishop.web.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.apnishop.web.data.entity.User;

@Transactional
public interface UserService {
	
	public User getUserByMobNo(String mob);
	public User getUserById(int id);
	public User getUserbyuname(String uname);
	public void addUser(User user);
	public void updateUser(String type, String role,int userid);
	public void updateUserProfile(String name, String mail,int langid,int userid);
	public void delUser(int id);
	public List<User> listUsers();
	

}
