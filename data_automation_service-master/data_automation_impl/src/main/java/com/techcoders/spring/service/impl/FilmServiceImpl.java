package com.techcoders.spring.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.database_config.annotation.Init;
import com.techcoders.spring.dto.FilmDTO;
import com.techcoders.spring.dto.ResponseDTO;
import com.techcoders.spring.entity.Film;
import com.techcoders.spring.manager.FilmManager;
import com.techcoders.spring.service.FilmService;

@Init
public class FilmServiceImpl implements FilmService {

	@Autowired
	private FilmManager filmManager;

	/** Implementation of Fetch Film. */
	@Override
	public List<FilmDTO> getFilm() {

		List<FilmDTO> filmDTOs = new ArrayList<>();
		filmManager.getFilms().stream().forEach(film -> {
			FilmDTO filmDTO = new FilmDTO();
			BeanUtils.copyProperties(film, filmDTO);
			filmDTO.setLanguage_name(film.getLanguage_id().getName());
			filmDTOs.add(filmDTO);

		});
		return filmDTOs;

	}

	/** Implementation of Add Film. */
	@Override
	public ResponseDTO postFilm(FilmDTO filmData) {
		Timestamp time = new Timestamp(11223344);
		ResponseDTO response = new ResponseDTO();
		try {
			Film film = new Film();

			BeanUtils.copyProperties(filmData, film);// name-->filmdata film-->id

			film.setLanguage_id(filmManager.getLanguageIdByName(filmData.getLanguage_name()));

			film.setLength(0);
			film.setRental_duration(0);
			film.setRental_rate(0.0);
			film.setReplacement_cost(0.0);
			film.setLast_update(time);
			film = filmManager.postFilm(film);
			response.setId(film.getFilm_id());
			response.setStatus(true);
			response.setMsg("Data Added Successfully");

		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(false);
			response.setMsg("Could not add your data");
		}
		return response;

	}

	/** Implementation of Update Film. */
	@Override
	public ResponseDTO updateFilm(FilmDTO filmData) {

		ResponseDTO response = new ResponseDTO();
		try {
			Film film = filmManager.findFilm(filmData.getFilm_id());
			BeanUtils.copyProperties(filmData, film);
			film.setLanguage_id(filmManager.getLanguageIdByName(filmData.getLanguage_name()));
			film = filmManager.updateFilm(film);
			response.setId(film.getFilm_id());
			response.setStatus(true);
			response.setMsg("Data Updated Successfully");

		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(false);
			response.setMsg("Could not Update your data");
		}
		return response;

	}

	/** Implementation of Delete Film. */
	@Override
	public ResponseDTO deleteFilm(List<Long> filmDatas) {
		ResponseDTO response = new ResponseDTO();
		try {
			filmDatas.stream().forEach(filmData -> {

				Film film = filmManager.findFilm(filmData);

				film.setIs_deleted(1);

				film = filmManager.deleteFilm(film);

//				response.setId(film.getFilm_id());

			});
			response.setStatus(true);
			response.setMsg("Data Deleted Successfully");

		} catch (Exception e) {
			e.printStackTrace();
			response.setStatus(false);
			response.setMsg("Could not delete your data");
		}
		return response;

	}

	/** Implementation of Search Film. */
	@Override
	public List<FilmDTO> searchFilm(FilmDTO filmData) {
		List<FilmDTO> filmDTOs = new ArrayList<>();
		filmManager.searchFilms(filmData).stream().forEach(film -> {
			FilmDTO filmDTO = new FilmDTO();
			BeanUtils.copyProperties(film, filmDTO);
			filmDTO.setLanguage_name(film.getLanguage_id().getName());
			filmDTOs.add(filmDTO);

		});
		return filmDTOs;
	}
	
	public List<FilmDTO> getFilmPagination(long row_num){
		try {
			List<FilmDTO> filmDTOs = new ArrayList<>();
			filmManager.getFilmPagination(row_num).stream().forEach(film ->{
				FilmDTO filmDTO = new FilmDTO();
				BeanUtils.copyProperties(film, filmDTO);
				filmDTO.setLanguage_name(film.getLanguage_id().getName());
				filmDTOs.add(filmDTO);
			});
			return filmDTOs;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}


}
