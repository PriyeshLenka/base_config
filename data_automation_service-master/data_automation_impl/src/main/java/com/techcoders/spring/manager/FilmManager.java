/*
 * Copyright 2006-2021 HighRadius Corporation
 */
package com.techcoders.spring.manager;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techcoders.spring.dao.FilmDAO;
import com.techcoders.spring.dto.FilmDTO;
import com.techcoders.spring.entity.Film;
import com.techcoders.spring.entity.Language;

/**
 * The Class FilmManager.
 */
@Component
public class FilmManager {

	/** The Film DAO. */
	@Autowired
	private FilmDAO filmDAO;

	/** The Fetch Films DAO. */
	public List<Film> getFilms() {
		try {
			return filmDAO.getFilm();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	/** The Language DAO. */
	public Language getLanguageIdByName(String language_name) {
		return filmDAO.getLanguageIdByName(language_name);
	}

	/** The ADD Film DAO. */
	public Film postFilm(Film film) {
		return filmDAO.postFilm(film);
		// filmManager
	}

	/** The Update Film DAO. */
	public Film updateFilm(Film film) {
		return filmDAO.updateFilm(film);
		// filmManager
	}

	/** The Delete Film DAO. */
	public Film deleteFilm(Film film) {
		return filmDAO.deleteFilm(film);
		// filmManager
	}

	/** The Find Film DAO. */
	public Film findFilm(Long film_id) {

		return filmDAO.findFilm(film_id);
	}

	/** The Search Film DAO. */
	public List<Film> searchFilms(FilmDTO filmData) {
		try {
			return filmDAO.searchFilm(filmData);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	public List<Film> getFilmPagination(long row_num){
		return filmDAO.getFilmPagination(row_num);
		
	}


}