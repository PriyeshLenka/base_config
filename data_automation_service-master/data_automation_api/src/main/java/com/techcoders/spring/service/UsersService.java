package com.techcoders.spring.service;

import java.util.List;

import com.techcoders.spring.dto.UsersDTO;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

/**
 * The Interface UsersService.
 */
@Path("/users")
public interface UsersService {

	/**
	 * Gets the users.
	 *
	 * @return the users
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<UsersDTO> getUsers();
}