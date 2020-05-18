package com.apnishop.web.data.dao;


import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.apnishop.web.data.entity.User;

public interface UserDAO extends CrudRepository<User, Long>{
	

	@Query("UPDATE User SET usertype=?1,userrole=?2 where id=?3")
	@Modifying
	public void updateUser(String type,String role,int userid);
	
	@Query("UPDATE User SET username=?1,email=?2,languageid=?3 where userguid=?4")
	@Modifying
	public void updateUserProfile(String username,String email,int langid,String userguid);
	
	
	@Query("SELECT max(userguid) from User")
	public String getMaxUserGUId();
	
	public User findByUsermobileno(String mob);
	public User findByUserguid(String guid);

}
