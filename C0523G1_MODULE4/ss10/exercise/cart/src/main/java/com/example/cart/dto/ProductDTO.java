package com.example.cart.dto;

import java.util.Objects;

public class ProductDTO {
    private int id;
    private String nameProduct;
    private double listedPrice;
    private double salePrice;
    private String describer;
    private int quantity;
    private String promotion;
    public String images;

    public ProductDTO() {
    }

    public ProductDTO(int id, String nameProduct, double listedPrice, double salePrice, String describer, int quantity,
                      String promotion, String images) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.listedPrice = listedPrice;
        this.salePrice = salePrice;
        this.describer = describer;
        this.quantity = quantity;
        this.promotion = promotion;
        this.images = images;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getListedPrice() {
        return listedPrice;
    }

    public void setListedPrice(double listedPrice) {
        this.listedPrice = listedPrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public String getDescriber() {
        return describer;
    }

    public void setDescriber(String describer) {
        this.describer = describer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDTO that = (ProductDTO) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
