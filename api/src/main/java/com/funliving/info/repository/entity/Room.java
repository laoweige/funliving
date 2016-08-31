package com.funliving.info.repository.entity;

import javax.ws.rs.FormParam;
import java.util.Date;

/**
 * Created by Administrator on 2016/8/3.
 */
public class Room {
    @FormParam("id")
    private int id;
    @FormParam("name")
    private String name;
    @FormParam("type")
    private int type;
    @FormParam("toilet")
    private int toilet;
    @FormParam("rent")
    private int rent;
    @FormParam("kitchen")
    private int kitchen;
    @FormParam("imprest")
    private int imprest;
    @FormParam("apartmentId")
    private int apartmentId;
    @FormParam("acreage1")
    private String acreage1;
    @FormParam("acreage2")
    private String acreage2;
    @FormParam("bed")
    private int bed;
    @FormParam("status")
    private int status;
    private Date createTime = new Date();


    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        this.bed = bed;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getToilet() {
        return toilet;
    }

    public void setToilet(int toilet) {
        this.toilet = toilet;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getKitchen() {
        return kitchen;
    }

    public void setKitchen(int kitchen) {
        this.kitchen = kitchen;
    }

    public int getImprest() {
        return imprest;
    }

    public void setImprest(int imprest) {
        this.imprest = imprest;
    }

    public int getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(int apartmentId) {
        this.apartmentId = apartmentId;
    }

    public String getAcreage1() {
        return acreage1;
    }

    public void setAcreage1(String acreage1) {
        this.acreage1 = acreage1;
    }

    public String getAcreage2() {
        return acreage2;
    }

    public void setAcreage2(String acreage2) {
        this.acreage2 = acreage2;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
