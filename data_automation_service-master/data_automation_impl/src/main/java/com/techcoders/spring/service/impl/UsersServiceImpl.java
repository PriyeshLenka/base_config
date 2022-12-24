package com.techcoders.spring.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.database_config.annotation.Init;
import com.techcoders.spring.dto.UsersDTO;
import com.techcoders.spring.manager.UsersManager;
import com.techcoders.spring.service.UsersService;

/**
 * The Class UsersServiceImpl.
 */
@Init
public class UsersServiceImpl implements UsersService {

	/** The users manager. */
	@Autowired
	private UsersManager usersManager;

	/**
	 * Gets the users.
	 *
	 * @return the users
	 */
	@Override
	public List<UsersDTO> getUsers() {
		List<UsersDTO> usersDTOs = new ArrayList<>();
		usersManager.getUsers().stream().forEach(users->{
			UsersDTO usersDTO = new UsersDTO();
			BeanUtils.copyProperties(users, usersDTO);
			usersDTOs.add(usersDTO);
		});
		return usersDTOs;
	}
}
