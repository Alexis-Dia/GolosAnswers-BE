package com.golosanswers.portal.rest.configuration.security;

import com.golosanswers.portal.exceptions.GolosanswersException;

import java.util.Arrays;

public enum Role {

	ADMIN("Administrator", "all", "ADMIN"),
	USER("Normal user", "limited", "USER");

	public final String text;
	public final String access;
	public final String role;

	Role(String text, String access, String role) {

		this.text = text;
		this.access = access;
		this.role = role;
	}

	public static Role byText(String text) {

		return Arrays.stream(values()).filter(role -> role.text.equals(text)).findAny().orElseThrow(GolosanswersException::new);
	}

	public static Role byRole(String text) {

		return Arrays.stream(values()).filter(role -> role.role.equals(text)).findAny().orElseThrow(GolosanswersException::new);
	}

	public String text() {

		return text;
	}

	public String role() {

		return role;
	}

	public String access() {

		return access;
	}
}
