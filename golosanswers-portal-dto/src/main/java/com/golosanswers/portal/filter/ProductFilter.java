package com.golosanswers.portal.filter;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

public class ProductFilter implements HasOrders, HasPageable {

    private final int page;
    private final int size;
    private final List<OrderBy> orders;

    private final String brand;
    private final String model;
    private final String description;
    private final Date dateEntreeFrom;
    private final Date dateEntreeTo;
    private final String selectedOptions;
    private final String productType;
    private final Double priceFrom;
    private final Double priceTo;
    private final Double ratingFrom;
    private final Double ratingTo;
    private final Boolean stockStatus;

    @JsonCreator
    public ProductFilter(@JsonProperty("page") int page, @JsonProperty("size") int size, @JsonProperty("orders") List<OrderBy> orders,
                         @JsonProperty("brand") String brand, @JsonProperty("model") String model, @JsonProperty("description") String description,
                         @JsonProperty("dateEntreeFrom") @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date dateEntreeFrom,
                         @JsonProperty("dateEntreeTo") @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date dateEntreeTo,
                         @JsonProperty("selectedOptions") String selectedOptions, @JsonProperty("productType") String productType,
                         @JsonProperty("priceFrom") Double priceFrom, @JsonProperty("priceTo") Double priceTo,
                         @JsonProperty("ratingFrom") Double ratingFrom, @JsonProperty("ratingTo") Double ratingTo,
                         @JsonProperty("stockStatus") Boolean stockStatus) {
        this.page = page;
        this.size = size;
        this.orders = orders;
        this.brand = brand;
        this.model = model;
        this.description = description;
        this.dateEntreeFrom = dateEntreeFrom;
        this.dateEntreeTo = dateEntreeTo;
        this.selectedOptions = selectedOptions;
        this.productType = productType;
        this.priceFrom = priceFrom;
        this.priceTo = priceTo;
        this.ratingFrom = ratingFrom;
        this.ratingTo = ratingTo;
        this.stockStatus = stockStatus;
    }

    @Override
    public List<OrderBy> getOrders() {
        return orders;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getPage() {
        return page;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getDescription() {
        return description;
    }

    public Date getDateEntreeFrom() {
        return dateEntreeFrom;
    }

    public Date getDateEntreeTo() {
        return dateEntreeTo;
    }

    public String getSelectedOptions() {
        return selectedOptions;
    }

    public String getProductType() {
        return productType;
    }

    public Double getPriceFrom() {
        return priceFrom;
    }

    public Double getPriceTo() {
        return priceTo;
    }

    public Double getRatingFrom() {
        return ratingFrom;
    }

    public Double getRatingTo() {
        return ratingTo;
    }

    public Boolean getStockStatus() {
        return stockStatus;
    }
}
