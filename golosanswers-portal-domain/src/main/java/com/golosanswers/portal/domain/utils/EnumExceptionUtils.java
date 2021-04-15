package com.golosanswers.portal.domain.utils;

import com.golosanswers.portal.domain.entity.enumeration.HasText;
import com.golosanswers.portal.exceptions.NonInstanceException;
import com.golosanswers.portal.utils.StringUtils;

import java.util.Arrays;
import java.util.stream.Collectors;

public final class EnumExceptionUtils {

	private EnumExceptionUtils() {

		throw new NonInstanceException(EnumExceptionUtils.class);
	}

	public static String exceptionMessage(Class<? extends HasText> enumeration, String text) {

		String allowedValues = Arrays.stream(enumeration.getEnumConstants()).map(HasText::getText).collect(Collectors.joining(StringUtils.COMMA_SPACE));
		return "Cannot define device type by input string [" + text + "]. Allowed values: [" + allowedValues + "]";
	}
}
