package com.golosanswers.portal.service.exceptions;

import com.golosanswers.portal.exceptions.GolosanswersException;

public class AlarmNotResolvedException extends GolosanswersException {

	public AlarmNotResolvedException() {

		super("Alarm is not resolved");
	}
}
