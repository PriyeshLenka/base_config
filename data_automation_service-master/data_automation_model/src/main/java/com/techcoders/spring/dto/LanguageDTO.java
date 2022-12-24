package com.techcoders.spring.dto;

import java.sql.Timestamp;

public class LanguageDTO {

	private int language_id;

	private String name;

	private Timestamp last_update;

	public int getLanguage_id() {
		return language_id;
	}

	public void setLanguage_id(int language_id) {
		this.language_id = language_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Timestamp getLast_update() {
		return last_update;
	}

	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}

}
