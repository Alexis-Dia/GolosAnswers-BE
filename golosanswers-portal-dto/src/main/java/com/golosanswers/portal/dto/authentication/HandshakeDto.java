package com.golosanswers.portal.dto.authentication;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HandshakeDto {

	private final String token;
	private final String access;
	private final String userName;
	private final String language;

	@JsonCreator
	public HandshakeDto(@JsonProperty("token") String token, @JsonProperty("access") String access, @JsonProperty("userName") String userName,
			@JsonProperty("language") String language) {

		this.token = token;
		this.access = access;
		this.userName = userName;
		this.language = language;
	}

	public String getToken() {

		return token;
	}

	public String getAccess() {

		return access;
	}

	public String getUserName() {

		return userName;
	}

	public String getLanguage() {

		return language;
	}
}
