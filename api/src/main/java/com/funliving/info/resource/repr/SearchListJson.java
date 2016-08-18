package com.funliving.info.resource.repr;

import java.util.List;

/**
 * Created by Administrator on 2016/8/18.
 */
public class SearchListJson {
    private List<SubApartmentJson> apartments;
    private List<CollegeJson> colleges;
    private long total;
    private String Address;
    private int city;

    public List<SubApartmentJson> getApartments() {
        return apartments;
    }

    public void setApartments(List<SubApartmentJson> apartments) {
        this.apartments = apartments;
    }

    public List<CollegeJson> getColleges() {
        return colleges;
    }

    public void setColleges(List<CollegeJson> colleges) {
        this.colleges = colleges;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "SearchListJson{" +
                "apartments=" + apartments +
                ", colleges=" + colleges +
                ", total=" + total +
                ", Address='" + Address + '\'' +
                ", city=" + city +
                '}';
    }
}
