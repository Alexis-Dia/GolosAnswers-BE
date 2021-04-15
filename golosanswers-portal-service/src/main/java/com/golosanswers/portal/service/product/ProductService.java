package com.golosanswers.portal.service.product;

import com.golosanswers.portal.dto.alarm.ProductDto;
import com.golosanswers.portal.filter.ProductFilter;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ProductService {

    Page<ProductDto> getProductPage(ProductFilter filter);
}
