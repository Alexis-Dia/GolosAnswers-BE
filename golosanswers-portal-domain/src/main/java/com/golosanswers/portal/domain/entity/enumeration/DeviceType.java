package com.golosanswers.portal.domain.entity.enumeration;

import com.golosanswers.portal.domain.exceptions.EnumerationException;
import com.golosanswers.portal.domain.utils.EnumExceptionUtils;

import java.util.Arrays;

public enum DeviceType implements HasText {

	WATCH("watch"),
	TRACKER("tracker");

	private final String text;

	DeviceType(String text) {

		this.text = text;
	}

	public static DeviceType byText(String text) {

		return Arrays.stream(values()).filter(value -> value.text.equals(text)).findAny()
				.orElseThrow(() -> new EnumerationException(EnumExceptionUtils.exceptionMessage(DeviceType.class, text)));
	}

	@Override
	public String getText() {

		return text;
	}
}
