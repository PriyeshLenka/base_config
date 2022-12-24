package com.techcoders.spring.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "film")
public class Film {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "film_id")
	private Long film_id;

	@Column(name = "title")
	private String title;

	@Column(name = "description")
	private String description;

	@Column(name = "release_year")
	private Integer release_year;

	@ManyToOne
	@JoinColumn(name = "language_id", referencedColumnName = "language_id")
	private Language language_id;

	@Column(name = "rental_duration")
	private Integer rental_duration;

	@Column(name = "rental_rate")
	private Double rental_rate;

	@Column(name = "length")
	private Integer length;

	@Column(name = "replacement_cost")
	private Double replacement_cost;

	@Column(name = "rating")
	private String rating;

	@Column(name = "special_features")
	private String special_features;

	@Column(name = "last_update")
	private Timestamp last_update;

	@Column(name = "is_deleted")
	private Integer is_deleted;

	@Column(name = "director")
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

	public Language getLanguage_id() {
		return language_id;
	}

	public void setLanguage_id(Language language_id) {
		this.language_id = language_id;
	}

	public Integer getRental_duration() {
		return rental_duration;
	}

	public void setRental_duration(Integer rental_duration) {
		this.rental_duration = rental_duration;
	}

	public Double getRental_rate() {
		return rental_rate;
	}

	public void setRental_rate(Double rental_rate) {
		this.rental_rate = rental_rate;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public Double getReplacement_cost() {
		return replacement_cost;
	}

	public void setReplacement_cost(Double replacement_cost) {
		this.replacement_cost = replacement_cost;
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

	public Timestamp getLast_update() {
		return last_update;
	}

	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
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