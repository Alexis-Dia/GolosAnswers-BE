package com.golosanswers.portal.utils;

import com.golosanswers.portal.exceptions.NonInstanceException;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public final class CollectionUtils {

	private CollectionUtils() {

		throw new NonInstanceException(CollectionUtils.class);
	}

	public static <T> Optional<T> firstListValueAsOptional(List<T> list) {

		if (Objects.isNull(list) || list.isEmpty()) {

			return Optional.empty();
		}

		return Optional.of(list.get(0));
	}

	public static <T> boolean nonContains(Collection<T> collection, T value) {

		return !collection.contains(value);
	}

	public static <T> boolean contains(Collection<T> collection, T value) {

		return collection.contains(value);
	}

	public static <T> boolean nonNullNonEmpty(Collection<T> collection) {

		return Objects.nonNull(collection) && !collection.isEmpty();
	}
}
