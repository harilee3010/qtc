package com.example.demo.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String manv;
    private String name;
    private String img;
    private String address;
    private String cmnd;
    private String phone;
    private String email;
    private String position;
    private Date dateOn;
    private String status;
    private Date dateOff;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManv() {
        return manv;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDateOn() {
        return dateOn;
    }

    public void setDateOn(Date dateOn) {
        this.dateOn = dateOn;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public Date getDateOff() {
        return dateOff;
    }

    public void setDateOff(Date dateOff) {
        this.dateOff = dateOff;
    }
}
