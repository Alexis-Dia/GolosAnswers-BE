package com.golosanswers.portal.dto.user;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDto {

	private final Long id;
	private final String username;
	private final String password;
	private final String firstName;
	private final String lastName;
	private final Role role;
	private final String language;

	@JsonCreator
	public UserDto(@JsonProperty("id") Long id, @JsonProperty("username") String username, @JsonProperty("password") String password, @JsonProperty("firstName") String firstName,
				   @JsonProperty("lastName") String lastName, @JsonProperty("role") Role role, @JsonProperty("language") String language) {

		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.role = role;
		this.language = language;
	}

	public Long getId() {

		return id;
	}

	public String getUsername() {

		return username;
	}

	public String getPassword() {

		return password;
	}

	public String getFirstName() {

		return firstName;
	}

	public String getLastName() {

		return lastName;
	}

	public Role getRole() {

		return role;
	}

	public String getLanguage() {

		return language;
	}
}
