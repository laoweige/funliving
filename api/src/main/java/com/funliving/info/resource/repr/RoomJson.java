package com.funliving.info.resource.repr;

import java.util.Date;
import com.funliving.info.repository.entity.Room;

public class RoomJson {

    public RoomJson(Room entity){


        this.id=entity.getId();
        this.images=entity.getImages();
        this.rent=entity.getRent();
        this.imprest=entity.getImprest();
        this.total=entity.getTotal();
        this.used=entity.getUsed();
        this.name=entity.getName();
        this.type=entity.getType();
        this.toilet=entity.getToilet();
        this.description=entity.getDescription();

        if(total>used)
            repertory=1;
    }

    public int repertory;

    public int getRepertory() {
        return repertory;
    }

    public void setRepertory(int repertory) {
        this.repertory = repertory;
    }

    /**
     *
     */
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     */
    private int apartmentId;
    public int getApartmentId() {
        return apartmentId;
    }
    public void setApartmentId(int apartmentId) {
        this.apartmentId = apartmentId;
    }

    /**
     *
     */
    private String images;
    public String getImages() {
        return images;
    }
    public void setImages(String images) {
        this.images = images;
    }

    /**
     *
     */
    private int rent;
    public int getRent() {
        return rent;
    }
    public void setRent(int rent) {
        this.rent = rent;
    }

    /**
     *
     */
    private int imprest;
    public int getImprest() {
        return imprest;
    }
    public void setImprest(int imprest) {
        this.imprest = imprest;
    }

    /**
     *
     */
    private int total;
//    public int getTotal() {
//        return total;
//    }
//    public void setTotal(int total) {
//        this.total = total;
//    }

    /**
     *
     */
    private int used;
//    public int getUsed() {
//        return used;
//    }
//    public void setUsed(int used) {
//        this.used = used;
//    }

    /**
     *
     */
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     */
    private int type;
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }

    /**
     *
     */
    private int toilet;
    public int getToilet() {
        return toilet;
    }
    public void setToilet(int toilet) {
        this.toilet = toilet;
    }

    /**
     *
     */
    private String description;
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }


}
