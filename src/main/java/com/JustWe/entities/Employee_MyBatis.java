package com.JustWe.entities;

import java.util.Date;

public class Employee_MyBatis {

	private Integer id;

	private String lastName;

	private Integer gender;

	private String email;

	private Integer dId;

    @Override
    public String toString() {
        return "Employee_MyBatis{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", dId=" + dId +
                '}';
    }

    public Employee_MyBatis(Integer id, String lastName, Integer gender, String email, Integer dId) {
        this.id = id;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.dId = dId;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public Integer getId() {

        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public Integer getdId() {
        return dId;
    }
}
