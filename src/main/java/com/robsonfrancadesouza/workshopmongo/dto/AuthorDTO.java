package com.robsonfrancadesouza.workshopmongo.dto;

import java.io.Serializable;

import com.robsonfrancadesouza.workshopmongo.domain.User;

public class AuthorDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String name;

	// Constructor
	public AuthorDTO() {

	}

	public AuthorDTO(User user) {
		id = user.getId();
		name = user.getName();
	}

	// getters and setters

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// end
}
