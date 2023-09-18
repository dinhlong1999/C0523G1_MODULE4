package com.example.practice3.model;

import org.springframework.web.multipart.MultipartFile;

public class ProductForm {
    private int id;
    private String name;
    private String description;
    private MultipartFile images;

    public ProductForm() {
    }

    public ProductForm(int id, String name, String description, MultipartFile images) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.images = images;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MultipartFile getImages() {
        return images;
    }

    public void setImages(MultipartFile images) {
        this.images = images;
    }
}
