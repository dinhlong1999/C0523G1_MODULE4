package com.example.seminar_test.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class CarDTO {
    private int id;
    @Pattern(regexp = "^[A-Z][a-z]+\\s*[a-z]+$", message = "Chữ cái đầu tiên phải viết hoa")
    private String name;
    @Size( max = 10, message = "Tối đa 10 kí tự")
    private String producer;
    private String describer;
    private TypeCar typeCar;

    public CarDTO() {
    }

    public CarDTO(int id, String name, String producer, String describer, TypeCar typeCar) {
        this.id = id;
        this.name = name;
        this.producer = producer;
        this.describer = describer;
        this.typeCar = typeCar;
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
