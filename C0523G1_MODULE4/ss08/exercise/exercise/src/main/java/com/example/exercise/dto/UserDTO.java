package com.example.exercise.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserDTO {
    private int id;
    @Size(min = 5,max = 45, message = "First name have minimum 5 character and maximum is 45 character")
    private String firstName;
    @Size(min = 5,max = 45, message = "Last name have minimum 5 character and maximum is 45 character")
    private String lastName;
    @Pattern(regexp = "^[0][0-9]{9}$", message = "Phone number must start 0 and have 10 numbers")
    private String phoneNumber;
    @Min(value = 18, message = "Age have larger than 18")
    private String age;
    @Email
    private String email;

    public UserDTO() {

    }

    public UserDTO(int id, String firstName, String lastName, String phoneNumber, String age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
