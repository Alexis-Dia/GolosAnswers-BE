package com.golosanswers.portal.utils;

import com.golosanswers.portal.exceptions.NonInstanceException;

import java.util.Objects;

public final class StringUtils {

	public static final String SPACE = " ";
	public static final String EMPTY = "";
	public static final String PERCENT = "%";
	public static final String DOT = ".";
	public static final String COMMA = ",";
	public static final String COMMA_SPACE = COMMA + SPACE;

	private StringUtils() {

		throw new NonInstanceException(StringUtils.class);
	}

	public static boolean nullOrEmpty(String str) {

		return Objects.isNull(str) || str.isEmpty();
	}

	public static boolean nonNullNonEmpty(String str) {

		return Objects.nonNull(str) && !str.isEmpty();
	}
}
