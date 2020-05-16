package com.apnishop.web.dto;

import java.util.List;

import org.mapstruct.Mapper;

import com.apnishop.web.data.entity.User;


@Mapper
public interface UserMapper {
	
	UserDTO toUserDTO(User user);
	
	UserLeadDTO toUserDTO(String data);

    List<UserDTO> toUserDTOs(List<User> users);

    User toUser(UserLeadDTO userDTO);

	
}
