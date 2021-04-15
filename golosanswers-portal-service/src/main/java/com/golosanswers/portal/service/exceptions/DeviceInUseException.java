package com.golosanswers.portal.service.exceptions;

import com.golosanswers.portal.exceptions.GolosanswersException;

public class DeviceInUseException extends GolosanswersException {

	public DeviceInUseException(String deviceId, String client) {

		super("Device id [" + deviceId + "] already in use by client [" + client + "]");
	}
}
