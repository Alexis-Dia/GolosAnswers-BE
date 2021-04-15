package com.golosanswers.portal.domain.specification;

import com.golosanswers.portal.domain.entity.ProductEntity;
import com.golosanswers.portal.domain.utils.SpecificationUtils;
import com.golosanswers.portal.filter.ProductFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ProductSpecification implements Specification<ProductEntity> {

    private static final String BRAND = "brand";
    private static final String MODEL = "model";
    private static final String DESCRIPTION = "description";
    private static final String DATE_ENTREE = "dateEntree";
    private static final String SELECTED_OPTIONS = "selectedOptions";
    private static final String PRODUCT_TYPE = "productType";
    private static final String PRICE = "price";
    private static final String RATING = "rating";
    private static final String STOCK_STATUS = "stockStatus";

    private final ProductFilter filter;

    private static final Map<String, String> PROPERTY_TO_ORDER;
    static {

        PROPERTY_TO_ORDER = new HashMap<>();
        PROPERTY_TO_ORDER.put(BRAND, BRAND);
        PROPERTY_TO_ORDER.put(MODEL, MODEL);
        PROPERTY_TO_ORDER.put(DESCRIPTION, DESCRIPTION);
        PROPERTY_TO_ORDER.put(DATE_ENTREE, DATE_ENTREE);
        PROPERTY_TO_ORDER.put(SELECTED_OPTIONS, SELECTED_OPTIONS);
        PROPERTY_TO_ORDER.put(PRODUCT_TYPE, PRODUCT_TYPE);
        PROPERTY_TO_ORDER.put(PRICE, PRICE);
        PROPERTY_TO_ORDER.put(RATING, RATING);
        PROPERTY_TO_ORDER.put(STOCK_STATUS, STOCK_STATUS);
    }

    public ProductSpecification(ProductFilter filter) {
        this.filter = filter;
    }

    @Override
    public Predicate toPredicate(Root<ProductEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        var predicates = new ArrayList<>();

        SpecificationUtils.equalBoolPredicate(root.get(STOCK_STATUS), filter.getStockStatus(), criteriaBuilder).ifPresent(predicates::add);
        SpecificationUtils.comparablePredicate(PRICE, filter.getPriceFrom(), filter.getPriceTo(), root, criteriaBuilder).ifPresent(predicates::add);
        SpecificationUtils.comparablePredicate(RATING, filter.getRatingFrom(), filter.getRatingTo(), root, criteriaBuilder).ifPresent(predicates::add);
        SpecificationUtils.likeIgnoreCasePredicate(root.get(BRAND), filter.getBrand(), criteriaBuilder).ifPresent(predicates::add);
        SpecificationUtils.likeIgnoreCasePredicate(root.get(MODEL), filter.getModel(), criteriaBuilder).ifPresent(predicates::add);
        SpecificationUtils.likeIgnoreCasePredicate(root.get(DESCRIPTION), filter.getModel(), criteriaBuilder).ifPresent(predicates::add);
        SpecificationUtils.likeIgnoreCasePredicate(root.get(SELECTED_OPTIONS), filter.getModel(), criteriaBuilder).ifPresent(predicates::add);
        SpecificationUtils.likeIgnoreCasePredicate(root.get(PRODUCT_TYPE), filter.getModel(), criteriaBuilder).ifPresent(predicates::add);
        SpecificationUtils.comparablePredicate(DATE_ENTREE, filter.getDateEntreeFrom(), filter.getDateEntreeTo(), root, criteriaBuilder).ifPresent(predicates::add);

        var orders = filter.getOrders();
        if (Objects.nonNull(orders) && !orders.isEmpty()) {

            var jpaOrders = SpecificationUtils.jpaOrders(root, orders, PROPERTY_TO_ORDER, criteriaBuilder);
            criteriaQuery.orderBy(jpaOrders);
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[] {}));
    }
}
