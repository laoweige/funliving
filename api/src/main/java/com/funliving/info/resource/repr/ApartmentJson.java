package com.funliving.info.resource.repr;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.funliving.info.repository.entity.Apartment;
import com.funliving.info.repository.entity.Facility;

public class ApartmentJson {

    public ApartmentJson(){
    }
    public ApartmentJson(Apartment entity){

        this.id=entity.getId();
        this.name=entity.getName();
        this.images=entity.getImages();
        this.address=entity.getAddress();
        this.serialNumber=entity.getSerialNumber();
        this.rent=entity.getRent();
        this.currency=entity.getCurrency();
        this.city=entity.getCity();
        this.coordinate=entity.getCoordinate();
        this.nation=entity.getNation();
        this.description=entity.getDescription();
    }



    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String images;

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String serialNumber;

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    private double rent;

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    private int currency;

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    private int city;

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    private String coordinate;

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    private int nation;

    public int getNation() {
        return nation;
    }

    public void setNation(int nation) {
        this.nation = nation;
    }

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private List<RoomJson> rooms = new ArrayList<>();
    private List<FacilityJson> facilities = new ArrayList<>();

    public List<RoomJson> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomJson> rooms) {
        this.rooms = rooms;
    }

    public List<FacilityJson> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<FacilityJson> facilities) {
        this.facilities = facilities;
    }
}