package com.golosanswers.portal.rest.controller.product;

import com.golosanswers.portal.RestNavigation;
import com.golosanswers.portal.dto.alarm.ProductDto;
import com.golosanswers.portal.filter.ProductFilter;
import com.golosanswers.portal.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RestNavigation.PRODUCT)
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {

        this.service = service;
    }

    @PostMapping(RestNavigation.LOAD)
    public Page<ProductDto> getAlarms(@RequestBody ProductFilter filter) {

        return service.getProductPage(filter);
    }
}
