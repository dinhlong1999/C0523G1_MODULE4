package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "book_name", columnDefinition = "varchar(255) not null")
    private String name;

    @Column(name = "quantity", columnDefinition = "int not null")
    private int quantity;

    @Column(columnDefinition = "varchar(255) not null")
    private String images;

    @Column(columnDefinition = "longtext not null")
    private String content;

    public Book() {
    }

    public Book(int id, String name, int quantity, String images, String content) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.images = images;
        this.content = content;

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
