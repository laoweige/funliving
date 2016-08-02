package com.funliving.info.repository.entity;

import java.util.Date;

/**
 * Created by Administrator on 2016/8/2.
 */
public class Apartment {
    private int id;
    private String name;
    private String images;
    private String address;
    private String serialNumber;
    private float rent;
    private int currency;

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

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public float getRent() {
        return rent;
    }

    public void setRent(float rent) {
        this.rent = rent;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public int getNation() {
        return nation;
    }

    public void setNation(int nation) {
        this.nation = nation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private int city;
    private String coordinate;
    private int nation;
    private String description;
    private Date createTime=new Date();

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    private Date lastTime=new Date();

    @Override
    public String toString() {
        return "Apartment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", images='" + images + '\'' +
                ", address='" + address + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", rent=" + rent +
                ", currency=" + currency +
                ", city=" + city +
                ", coordinate='" + coordinate + '\'' +
                ", nation=" + nation +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                ", lastTime=" + lastTime +
                '}';
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }
}
