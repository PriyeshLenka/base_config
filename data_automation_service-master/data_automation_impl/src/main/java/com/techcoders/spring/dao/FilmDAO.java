package com.techcoders.spring.dao;

import java.util.List;



import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techcoders.spring.config.DarkDBConfig;
import com.techcoders.spring.dto.FilmDTO;
import com.techcoders.spring.entity.Film;
import com.techcoders.spring.entity.Language;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * The Class FilmDAO.
 */
@Repository
public class FilmDAO {

	/** The entity manager. */
	@PersistenceContext(unitName = DarkDBConfig.DARKDB_PU)
	private EntityManager entityManager;

	/** FETCH FILM */
	public List<Film> getFilm() {
		try {
			return entityManager.createQuery("from Film", Film.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	

	/** ADD NEW FILM */
	@Transactional
	public Film postFilm(Film film) {
		entityManager.persist(film);
		return film;
	}

	/** UPDATE EXISTING FILM */
	@Transactional
	public Film updateFilm(Film film) {
		entityManager.merge(film);
		return film;
	}

	/** DELETE EXISTING FILM */
	@Transactional
	public Film deleteFilm(Film film) {
		entityManager.merge(film);
		return film;
	}

	/** FIND FILM BY ID */

	public Film findFilm(Long filmId) {
		return entityManager.find(Film.class, filmId);
	}

	/** Get Language ID by Name */
	public Language getLanguageIdByName(String language) {
		return entityManager.createQuery("from Language where name=(:name)", Language.class)
				.setParameter("name", language).getSingleResult();
	}

	/** Search film */
	public List<Film> searchFilm(FilmDTO filmData) {

		String query = " from Film where";
		if (filmData.getTitle() != null) {
			query += " title='" + filmData.getTitle() + "' and";

		}
		if (filmData.getDirector() != null) {
			query += " director= '" + filmData.getDirector() + "' and";

		}
		if (filmData.getRelease_year() != null) {
			query += " release_year= '" + filmData.getRelease_year() + "' and";

		}
		if (filmData.getLanguage_name() != null) {
			query += " language_id= '" + getLanguageIdByName(filmData.getLanguage_name()).getLanguage_id() + "' and";

		}
		System.err.println(query);
		String fQuery = query.substring(0, query.length() - 3);
		System.err.println(fQuery);
		try {
			return entityManager.createQuery(fQuery, Film.class).getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
	
	public List<Film> getFilmPagination(long row_num){
		List<Film> film = entityManager.createQuery("from Film where is_deleted=0", Film.class)
				.setFirstResult((int)row_num-1)
				.setMaxResults(5).getResultList();
		
		return film;
	}



}