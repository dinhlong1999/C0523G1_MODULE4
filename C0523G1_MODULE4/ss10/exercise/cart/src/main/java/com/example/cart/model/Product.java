package com.example.cart.model;

import javax.persistence.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name_product", columnDefinition = "varchar(255) not null")
    private String nameProduct;

    @Column(name = "listed_price" ,columnDefinition = "double not null")
    private double listedPrice;

    @Column(name = "sale_price",columnDefinition = "double not null")
    private double salePrice;

    @Column(columnDefinition = "varchar(255) not null")
    private String describer;

    @Column(columnDefinition = "int not null")
    private int quantity;

    @Column(columnDefinition = "text not null")
    private String promotion;

    @Column(columnDefinition = "varchar(255) not null")
    public String images;


    public Product() {
    }

    public Product(int id, String nameProduct, double listedPrice, double salePrice, String describer, int quantity, String promotion, String images) {
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
//    public String formatCurrency(double amount) {
//        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(Locale.US);
//        decimalFormat.applyPattern("###,###,###");
//        return decimalFormat.format(amount);
//    }
//    public String formatListedPrice() {
//        Product product = new Product();
//        String formattedAmount = product.formatCurrency(listedPrice);
//        System.out.println(formattedAmount);
//        return formattedAmount;
//    }
//    public String formatSalePrice() {
//        Product product = new Product();
//        String formattedAmount = product.formatCurrency(salePrice);
//        System.out.println(formattedAmount);
//        return formattedAmount;
//    }
}
