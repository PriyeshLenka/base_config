package com.techcoders.spring.dao;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.techcoders.spring.config.DarkDBConfig;
import com.techcoders.spring.entity.Users;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * The Class UsersDAO.
 */
@Repository
public class UsersDAO {

	/** The entity manager. */
	@PersistenceContext(unitName = DarkDBConfig.DARKDB_PU)
	private EntityManager entityManager;

	/**
	 * Gets the users.
	 *
	 * @return the users
	 */
	public List<Users> getUsers() {
		return entityManager.createQuery("from Users", Users.class).getResultList();
	}
}