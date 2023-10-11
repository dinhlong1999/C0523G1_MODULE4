package com.example.seminar_test2.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Pig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String codePig;
    private String weight;
    private String timeInput;

    private String timeOutput;
    private String weightOut;

    @ManyToOne
    @JoinColumn(name = "originID",referencedColumnName = "id")
    private Origin origin;

    public Pig() {
    }

    public Pig(int id, String codePig, String weight, String timeInput, String timeOutput, String weightOut, Origin origin) {
        this.id = id;
        this.codePig = codePig;
        this.weight = weight;
        this.timeInput = timeInput;
        this.timeOutput = timeOutput;
        this.weightOut = weightOut;
        this.origin = origin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodePig() {
        return codePig;
    }

    public void setCodePig(String codePig) {
        this.codePig = codePig;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getTimeInput() {
        return timeInput;
    }

    public void setTimeInput(String timeInput) {
        this.timeInput = timeInput;
    }

    public String getTimeOutput() {
        return timeOutput;
    }

    public void setTimeOutput(String timeOutput) {
        this.timeOutput = timeOutput;
    }

    public String getWeightOut() {
        return weightOut;
    }

    public void setWeightOut(String weightOut) {
        this.weightOut = weightOut;
    }

    public Origin getOrigin() {
        return origin;
    }

    public void setOrigin(Origin origin) {
        this.origin = origin;
    }
}
