package com.golosanswers.portal.dto.email;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class EmailDto {

	private final Long id;
	private final EmailTypeDto emailType;
	private final Date sentAt;
	private final String message;
	private final String recipient;

	@JsonCreator
	public EmailDto(@JsonProperty("id") Long id, @JsonProperty("emailType") EmailTypeDto emailType,
			@JsonProperty("sentAt") @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date sentAt, @JsonProperty("message") String message,
			@JsonProperty("recipient") String recipient) {

		this.id = id;
		this.emailType = emailType;
		this.sentAt = sentAt;
		this.message = message;
		this.recipient = recipient;
	}

	public Long getId() {

		return id;
	}

	public EmailTypeDto getEmailType() {

		return emailType;
	}

	public Date getSentAt() {

		return sentAt;
	}

	public String getMessage() {

		return message;
	}

	public String getRecipient() {

		return recipient;
	}
}
