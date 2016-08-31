package com.funliving.info.resource.repr;

import java.util.Date;
import com.funliving.info.repository.entity.Room;

public class RoomJson {

    public RoomJson(Room entity){

        this.id=entity.getId();
        this.rent=entity.getRent();
        this.imprest=entity.getImprest();
        this.name=entity.getName();
        this.type=entity.getType();
        this.toilet=entity.getToilet();
        this.kitchen = entity.getKitchen();
        this.acreage1 = entity.getAcreage1();
        this.status = entity.getStatus();
        this.bed = entity.getBed();
        this.acreage1 = entity.getAcreage1();
        this.acreage2 = entity.getAcreage2();

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

    public int getBed() {
        return bed;
    }

    public void setBed(int bed) {
        this.bed = bed;
    }

    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    private int apartmentId;
    public int getApartmentId() {
        return apartmentId;
    }
    public void setApartmentId(int apartmentId) {
        this.apartmentId = apartmentId;
    }

    private int rent;
    public int getRent() {
        return rent;
    }
    public void setRent(int rent) {
        this.rent = rent;
    }

    private int imprest;
    public int getImprest() {
        return imprest;
    }
    public void setImprest(int imprest) {
        this.imprest = imprest;
    }

    private int status;

    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    private int type;
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }

    private int toilet;
    public int getToilet() {
        return toilet;
    }
    public void setToilet(int toilet) {
        this.toilet = toilet;
    }


    private String acreage1;
    private String acreage2;
    private int bed;

    private int kitchen;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getKitchen() {
        return kitchen;
    }

    public void setKitchen(int kitchen) {
        this.kitchen = kitchen;
    }
}
