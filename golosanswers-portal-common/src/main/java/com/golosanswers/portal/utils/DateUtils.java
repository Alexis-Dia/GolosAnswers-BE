package com.golosanswers.portal.utils;

import com.golosanswers.portal.exceptions.NonInstanceException;

import java.util.Date;

public final class DateUtils {

	private DateUtils() {

		throw new NonInstanceException(DateUtils.class);
	}

	public static Date addMilliseconds(Date date, long ms) {

		return org.apache.commons.lang3.time.DateUtils.addMilliseconds(date, (int) ms);
	}

	public static Date addSeconds(Date date, int seconds) {

		return org.apache.commons.lang3.time.DateUtils.addSeconds(date, seconds);
	}

	public static Date now() {

		return new Date();
	}

	public static Date zeroTime() {

		return new Date(0);
	}
}
