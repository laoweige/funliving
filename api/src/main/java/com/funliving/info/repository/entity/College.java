package com.funliving.info.repository.entity;


public class College {

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

    private int cityId;
    public int getCityId() {
        return cityId;
    }
    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    private int nationId;
    public int getNationId() {
        return nationId;
    }
    public void setNationId(int nationId) {
        this.nationId = nationId;
    }

    private String coordinate;
    public String getCoordinate() {
        return coordinate;
    }
    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

}
