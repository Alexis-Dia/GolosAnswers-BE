package com.golosanswers.portal.service;

public interface WebSocketNavigation {

	String WS_ROOT = "/ws";

	String WS_ALL_PATTERN = WS_ROOT + "/**";
	String NEW_ALARM = "/alarm/new";

	//for developing purposes
	String NEW_ALARM_TEST = NEW_ALARM + "/test";
}
