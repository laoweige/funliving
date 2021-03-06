package com.funliving.info.resource.repr;

import com.funliving.info.repository.entity.Apartment;
import com.funliving.info.repository.entity.Distance;
import org.apache.solr.client.solrj.beans.Field;

import java.util.ArrayList;
import java.util.List;

public class ApartmentJson {

    public ApartmentJson(){
    }
    private String postcode;
    private String supplier;

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public ApartmentJson(Apartment entity){

        this.id=entity.getId();
        this.name=entity.getName();
        this.images=entity.getImages();
        this.address=entity.getAddress();
        this.postcode=entity.getPostcode();
        this.supplier = entity.getSupplier();
        this.rent=entity.getRent();
        this.currency=entity.getCurrency();
        this.city=entity.getCity();
        this.coordinate=entity.getCoordinate();
        this.nation=entity.getNation();
        this.description=entity.getDescription();
        this.rank = entity.getRank();
    }

    private DistanceJson distance;

    public DistanceJson getDistance() {
        return distance;
    }

    public void setDistance(DistanceJson distance) {
        this.distance = distance;
    }

    @Field("Rank")
    private int rank;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Field("Id")
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Field("Apartment")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Field("Images")
    private String images;

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    @Field("Address")
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Field("Rent")
    private int rent;

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    private int currency;

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    @Field("City")
    private int city;

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    @Field("Coordinate")
    private String coordinate;

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    @Field("Nation")
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

    private List<PictureJson> pictures=new ArrayList<>();

    public List<PictureJson> getPictures() {
        return pictures;
    }

    public void setPictures(List<PictureJson> pictures) {
        this.pictures = pictures;
    }

    private List<IntroduceJson> introduces=new ArrayList<>();

    public List<IntroduceJson> getIntroduces() {
        return introduces;
    }

    public void setIntroduces(List<IntroduceJson> introduces) {
        this.introduces = introduces;
    }
}