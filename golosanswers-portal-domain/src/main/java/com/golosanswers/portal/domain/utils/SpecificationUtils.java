package com.golosanswers.portal.domain.utils;

import com.golosanswers.portal.domain.exceptions.OrderException;
import com.golosanswers.portal.exceptions.NonInstanceException;
import com.golosanswers.portal.filter.OrderBy;
import com.golosanswers.portal.utils.StringUtils;

import javax.persistence.criteria.*;
import java.util.*;
import java.util.regex.Pattern;

public final class SpecificationUtils {

	private static final String ASC = "ASC";
	private static final String DESC = "DESC";

	private SpecificationUtils() {

		throw new NonInstanceException(SpecificationUtils.class);
	}

	public static <T extends Comparable<? super T>> Optional<Predicate> comparablePredicate(String key, T from, T to, Path<?> elementPath, CriteriaBuilder criteriaBuilder) {

		Path<? extends T> path = elementPath.get(key);

		if (Objects.nonNull(from) && Objects.nonNull(to)) {

			Predicate predicate = criteriaBuilder.between(path, from, to);
			return Optional.of(predicate);

		} else if (Objects.nonNull(from)) {

			Predicate predicate = criteriaBuilder.greaterThanOrEqualTo(path, from);
			return Optional.of(predicate);

		} else if (Objects.nonNull(to)) {

			Predicate predicate = criteriaBuilder.lessThanOrEqualTo(path, to);
			return Optional.of(predicate);
		}

		return Optional.empty();
	}

	public static Optional<Predicate> likeIgnoreCasePredicate(Path<?> elementPath, String value, CriteriaBuilder criteriaBuilder) {

		if (StringUtils.nonNullNonEmpty(value)) {

			Path<String> path = (Path<String>) elementPath;
			Predicate predicate = criteriaBuilder.like(criteriaBuilder.upper(path), StringUtils.PERCENT + value.toUpperCase() + StringUtils.PERCENT);
			return Optional.of(predicate);
		}
		return Optional.empty();
	}

	//Can be using with comparing of entities-types
	public static <T> Optional<Predicate> equalPredicate(Path<T> path, T value, CriteriaBuilder criteriaBuilder) {

		if (Objects.isNull(value) || ((value instanceof String) && StringUtils.nullOrEmpty((String) value))) {

			return Optional.empty();
		}

		Predicate predicate = criteriaBuilder.equal(path, value);
		return Optional.of(predicate);
	}

	public static <T> Optional<Predicate> equalBoolPredicate(Path<T> path, T value, CriteriaBuilder criteriaBuilder) {

		if (Objects.isNull(value) || ((value instanceof String) && StringUtils.nullOrEmpty((String) value))) {

			return Optional.empty();
		}

		Path<Boolean> pa = (Path<Boolean>) path;
		Boolean val = (Boolean) value;
		Predicate predicate = val ? criteriaBuilder.isTrue(pa) : criteriaBuilder.isFalse(pa);
		return Optional.of(predicate);
	}

	public static List<Order> jpaOrders(Root<?> root, List<OrderBy> orders, Map<String, String> propertyToOrders, CriteriaBuilder criteriaBuilder) {

		Collections.sort(orders);

		List<Order> jpaOrders = new ArrayList<>();

		orders.forEach(order -> {

			String property = order.getProperty();
			String jpaPath = propertyToOrders.get(property);

			if (StringUtils.nullOrEmpty(jpaPath)) {
				throw new OrderException(property);
			}

			String[] array = jpaPath.split(Pattern.quote(StringUtils.DOT));
			var path = findPath(root, array);

			String direction = order.getDirection();
			if (ASC.equals(direction)) {
				jpaOrders.add(criteriaBuilder.asc(path));
			} else if (DESC.equals(direction)) {
				jpaOrders.add(criteriaBuilder.desc(path));
			} else {
				throw new OrderException(direction);
			}
		});

		return jpaOrders;

	}

	private static Path<?> findPath(Root<?> root, String[] array) {

		Path<?> path = root;

		for (String element : array) {
			path = path.get(element);
		}

		return path;
	}

}
