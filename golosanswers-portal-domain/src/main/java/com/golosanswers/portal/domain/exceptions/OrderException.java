package com.golosanswers.portal.domain.exceptions;

public class OrderException extends DomainException {

	public OrderException(String property) {

		super("Property [" + property + "] is not implemented or configured incorrectly.");
	}
}
