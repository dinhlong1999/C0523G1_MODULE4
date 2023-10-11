package com.example.seminar_test.model;

import javax.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String producer;
    private String describer;

    @ManyToOne
    @JoinColumn(name = "typeId", referencedColumnName = "id")
    private TypeCar typeCar;


    public Car(int id, String name, String producer, String describer, TypeCar typeCar) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.describer = describer;
        this.typeCar = typeCar;
    }

    public Car() {
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

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getDescriber() {
        return describer;
    }

    public void setDescriber(String describer) {
        this.describer = describer;
    }

    public TypeCar getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(TypeCar typeCar) {
        this.typeCar = typeCar;
    }
}
