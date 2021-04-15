package com.golosanswers.portal.domain.specification;

import com.golosanswers.portal.domain.entity.PostEntity;
import com.golosanswers.portal.domain.utils.SpecificationUtils;
import com.golosanswers.portal.filter.PostFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PostSpecification implements Specification<PostEntity> {

    private static final String AUTHOR = "author";
    private static final String URL = "url";
    private static final String TAG = "tag";
    private static final String PARENT_PERMLINK = "parentPermlink";
    private static final String LINK = "link";
    private static final String TITLE = "title";
    private static final String KEYWORDS = "keywords";
    private static final String BODY = "body";
    private static final String RATING = "rating";
    private static final String COMMENTS = "comments";

    private final PostFilter filter;

    private static final Map<String, String> PROPERTY_TO_ORDER;
    static {

        PROPERTY_TO_ORDER = new HashMap<>();
        PROPERTY_TO_ORDER.put(AUTHOR, AUTHOR);
        PROPERTY_TO_ORDER.put(URL, URL);
        PROPERTY_TO_ORDER.put(TAG, TAG);
        PROPERTY_TO_ORDER.put(PARENT_PERMLINK, PARENT_PERMLINK);
        PROPERTY_TO_ORDER.put(LINK, LINK);
        PROPERTY_TO_ORDER.put(TITLE, TITLE);
        PROPERTY_TO_ORDER.put(KEYWORDS, KEYWORDS);
        PROPERTY_TO_ORDER.put(BODY, BODY);
        PROPERTY_TO_ORDER.put(RATING, RATING);
        PROPERTY_TO_ORDER.put(COMMENTS, COMMENTS);
    }

    public PostSpecification(PostFilter filter) {
        this.filter = filter;
    }

    @Override
    public Predicate toPredicate(Root<PostEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        var predicates = new ArrayList<>();

        SpecificationUtils.likeIgnoreCasePredicate(root.get(AUTHOR), filter.getAuthor(), criteriaBuilder).ifPresent(predicates::add);
        SpecificationUtils.likeIgnoreCasePredicate(root.get(URL), filter.getUrl(), criteriaBuilder).ifPresent(predicates::add);
        SpecificationUtils.likeIgnoreCasePredicate(root.get(TAG), filter.getTag(), criteriaBuilder).ifPresent(predicates::add);
        SpecificationUtils.likeIgnoreCasePredicate(root.get(PARENT_PERMLINK), filter.getParentPermlink(), criteriaBuilder).ifPresent(predicates::add);
        SpecificationUtils.likeIgnoreCasePredicate(root.get(LINK), filter.getLink(), criteriaBuilder).ifPresent(predicates::add);
        SpecificationUtils.likeIgnoreCasePredicate(root.get(TITLE), filter.getTitle(), criteriaBuilder).ifPresent(predicates::add);
        SpecificationUtils.likeIgnoreCasePredicate(root.get(KEYWORDS), filter.getKeywords(), criteriaBuilder).ifPresent(predicates::add);
        SpecificationUtils.likeIgnoreCasePredicate(root.get(BODY), filter.getKeywords(), criteriaBuilder).ifPresent(predicates::add);
        SpecificationUtils.comparablePredicate(RATING, filter.getRatingFrom(), filter.getRatingTo(), root, criteriaBuilder).ifPresent(predicates::add);
        SpecificationUtils.comparablePredicate(COMMENTS, filter.getCommentsFrom(), filter.getCommentsTo(), root, criteriaBuilder).ifPresent(predicates::add);

        var orders = filter.getOrders();
        if (Objects.nonNull(orders) && !orders.isEmpty()) {

            var jpaOrders = SpecificationUtils.jpaOrders(root, orders, PROPERTY_TO_ORDER, criteriaBuilder);
            criteriaQuery.orderBy(jpaOrders);
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[] {}));
    }
}
