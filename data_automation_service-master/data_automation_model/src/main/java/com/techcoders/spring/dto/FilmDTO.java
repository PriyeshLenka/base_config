package com.techcoders.spring.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class FilmDTO {

	private Long film_id;

	private String title;
	private String description;
	private Integer release_year;
	private String language_name;
	private String rating;
	private String special_features;
	private Integer is_deleted;
	private String director;

	public Long getFilm_id() {
		return film_id;
	}

	public void setFilm_id(Long film_id) {
		this.film_id = film_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getRelease_year() {
		return release_year;
	}

	public void setRelease_year(Integer release_year) {
		this.release_year = release_year;
	}

	public String getLanguage_name() {
		return language_name;
	}

	public void setLanguage_name(String language_name) {
		this.language_name = language_name;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecial_features() {
		return special_features;
	}

	public void setSpecial_features(String special_features) {
		this.special_features = special_features;
	}

	public Integer getIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(Integer is_deleted) {
		this.is_deleted = is_deleted;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

}
