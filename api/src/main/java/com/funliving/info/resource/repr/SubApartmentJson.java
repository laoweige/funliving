package com.funliving.info.resource.repr;

/**
 * Created by Administrator on 2016/8/18.
 */
public class SubApartmentJson {
    private int id;
    private String name;
    private String images;
    private String address;
    private int rent;
    private int rank;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
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

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    @Override
    public String toString() {
        return "SubApartmentJson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", images='" + images + '\'' +
                ", address='" + address + '\'' +
                ", rent=" + rent +
                ", rank=" + rank +
                '}';
    }
}
