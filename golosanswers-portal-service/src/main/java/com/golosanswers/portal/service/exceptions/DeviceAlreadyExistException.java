package com.golosanswers.portal.service.exceptions;

import com.golosanswers.portal.exceptions.GolosanswersException;

public class DeviceAlreadyExistException extends GolosanswersException {

	public DeviceAlreadyExistException(String deviceId) {

		super("Device with such id [" + deviceId + "] already exist");
	}
}
