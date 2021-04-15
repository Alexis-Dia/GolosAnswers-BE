package com.golosanswers.portal.dto.alarm;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class ProductDto {

    private final Long id;
    private final String brand;
    private final String model;
    private final String description;
    private final Date dateEntree;
    private final String selectedOptions;
    private final String productType;
    private final Double price;
    private final Double rating;
    private final Boolean stockStatus;

    @JsonCreator
    public ProductDto(@JsonProperty("id") Long id, @JsonProperty("brand") String brand, @JsonProperty("model") String model,
                      @JsonProperty("description") String description, @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss") @JsonProperty("dateEntree") Date dateEntree,
                      @JsonProperty("selectedOptions") String selectedOptions, @JsonProperty("productType") String productType,
                      @JsonProperty("price") Double price, @JsonProperty("rating") Double rating,
                      @JsonProperty("stockStatus") Boolean stockStatus) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.description = description;
        this.dateEntree = dateEntree;
        this.selectedOptions = selectedOptions;
        this.productType = productType;
        this.price = price;
        this.rating = rating;
        this.stockStatus = stockStatus;
    }

    public Long getId() {
        return id;
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

    public Date getDateEntree() {
        return dateEntree;
    }

    public String getSelectedOptions() {
        return selectedOptions;
    }

    public String getProductType() {
        return productType;
    }

    public Double getPrice() {
        return price;
    }

    public Double getRating() {
        return rating;
    }

    public Boolean getStockStatus() {
        return stockStatus;
    }
}
