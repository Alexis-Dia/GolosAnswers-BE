package com.golosanswers.portal.exceptions;

public class ObjectNullException extends GolosanswersException {

	public ObjectNullException() {

	}

	public ObjectNullException(String objectName) {

		super("Required requested property" + objectName + " is null or empty.");
	}
}
