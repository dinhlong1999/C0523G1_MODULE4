package com.example.demo.model;

import org.springframework.data.domain.PageRequest;

import javax.persistence.*;

@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(columnDefinition = "int unique")
    private int code;

    @Column(columnDefinition = "int not null")
    private int quantity;
    @Column(name = "customer_name" ,columnDefinition = "varchar(255) not null")
    private String customerName;

    @OneToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    public Bill() {
    }

    public Bill(int id, int code, int quantity, String customerName, Book book) {
        this.id = id;
        this.code = code;
        this.quantity = quantity;
        this.customerName = customerName;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
