/*
 * Copyright 2006-2021 HighRadius Corporation
 */
package com.techcoders.spring.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techcoders.spring.dao.UsersDAO;
import com.techcoders.spring.entity.Users;

/**
 * The Class UsersManager.
 */
@Component
public class UsersManager {

	/** The users DAO. */
	@Autowired
	private UsersDAO usersDAO;

	/**
	 * Gets the users.
	 *
	 * @return the users
	 */
	public List<Users> getUsers() {
		return usersDAO.getUsers();
	}
}