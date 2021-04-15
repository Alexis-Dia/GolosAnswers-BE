package com.golosanswers.portal.service.product.impl;

import com.golosanswers.portal.domain.entity.ProductEntity;
import com.golosanswers.portal.domain.repository.ProductRepository;
import com.golosanswers.portal.domain.specification.ProductSpecification;
import com.golosanswers.portal.dto.alarm.ProductDto;
import com.golosanswers.portal.filter.ProductFilter;
import com.golosanswers.portal.service.mapper.DtoMapper;
import com.golosanswers.portal.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    @Override
    public Page<ProductDto> getProductPage(ProductFilter filter) {

        Pageable pageable = PageRequest.of(filter.getPage(), filter.getSize());
        Specification<ProductEntity> specification = new ProductSpecification(filter);

        return productRepository.findAll(specification, pageable).map(DtoMapper::toProductDto);
    }
}
