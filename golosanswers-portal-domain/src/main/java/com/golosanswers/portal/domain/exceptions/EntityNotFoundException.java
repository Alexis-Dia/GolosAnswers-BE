package com.golosanswers.portal.domain.exceptions;

public class EntityNotFoundException extends DomainException {

	public EntityNotFoundException(String message) {

		super(message);
	}

	public EntityNotFoundException() {

		this("Requested entity not found.");
	}

}
