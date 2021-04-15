package com.golosanswers.portal.dto.websocket;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WebSocketDto {

	private final WebSocketEvent event;
	private final String message;

	@JsonCreator
	public WebSocketDto(@JsonProperty("event") WebSocketEvent event, @JsonProperty("message") String message) {

		this.event = event;
		this.message = message;
	}

	public WebSocketEvent getEvent() {

		return event;
	}

	public String getMessage() {

		return message;
	}
}
