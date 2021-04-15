package com.golosanswers.portal.service.exceptions;

import com.golosanswers.portal.exceptions.GolosanswersException;

public class BeaconDataException extends GolosanswersException {

	public BeaconDataException() {

		super("Beacons size must be 3 or less");
	}
}
