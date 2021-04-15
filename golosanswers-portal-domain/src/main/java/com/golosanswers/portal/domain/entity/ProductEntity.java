package com.golosanswers.portal.domain.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "description")
    private String description;

    @Column(name = "date_entree")
    private Date dateEntree;

    @Column(name = "selected_options")
    private String selectedOptions;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "old_price")
    private Double oldPrice;

    @Column(name = "price")
    private Double price;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "stock_status")
    private Boolean stockStatus;

    public ProductEntity() {

    }

    public ProductEntity(String brand, String model, String description, Date dateEntree, String selectedOptions,
                         String productType, String imagePath, Double oldPrice, Double price, Double rating, Boolean stockStatus) {
        this.brand = brand;
        this.model = model;
        this.description = description;
        this.dateEntree = dateEntree;
        this.selectedOptions = selectedOptions;
        this.productType = productType;
        this.imagePath = imagePath;
        this.oldPrice = oldPrice;
        this.price = price;
        this.rating = rating;
        this.stockStatus = stockStatus;
    }

    public Long getId() {
        return product_id;
    }

    public void setId(Long id) {
        this.product_id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateEntree() {
        return dateEntree;
    }

    public void setDateEntree(Date dateEntree) {
        this.dateEntree = dateEntree;
    }

    public String getSelectedOptions() {
        return selectedOptions;
    }

    public void setSelectedOptions(String selectedOptions) {
        this.selectedOptions = selectedOptions;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(Double oldPrice) {
        this.oldPrice = oldPrice;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Boolean getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(Boolean stockStatus) {
        this.stockStatus = stockStatus;
    }
}
