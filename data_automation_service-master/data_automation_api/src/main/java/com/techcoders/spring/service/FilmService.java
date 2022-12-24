package com.techcoders.spring.service;

import java.util.List;

import com.techcoders.spring.dto.FilmDTO;
import com.techcoders.spring.dto.ResponseDTO;

import jakarta.websocket.server.PathParam;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/film")
public interface FilmService {

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	public List<FilmDTO> getFilm();

	@POST
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public ResponseDTO postFilm(FilmDTO film);

	@PUT
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public ResponseDTO updateFilm(FilmDTO film);

	@PUT
	@Path("/delete")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public ResponseDTO deleteFilm(List<Long> film);

	@POST
	@Path("/search")
	@Produces({ MediaType.APPLICATION_JSON })
	public List<FilmDTO> searchFilm(FilmDTO filmData);

	@GET
	@Path("/pagination/{row: [0-9]*}")
	@Produces({ MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_JSON })
	public List<FilmDTO> getFilmPagination(@PathParam("row") long row);

}
