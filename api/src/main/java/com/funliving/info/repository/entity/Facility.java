package com.funliving.info.repository.entity;

/**
 * Created by Administrator on 2016/8/3.
 */
public class Facility {
    private int id;
    private int apartmentId;
    private int facility;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(int apartmentId) {
        this.apartmentId = apartmentId;
    }

    public int getFacility() {
        return facility;
    }

    public void setFacility(int facility) {
        this.facility = facility;
    }
}
