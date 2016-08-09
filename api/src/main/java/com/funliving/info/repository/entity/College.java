package com.funliving.info.repository.entity;

import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class College {

    @FormParam("id")
    private int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @FormParam("name")
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @FormParam("cityId")
    private int cityId;
    public int getCityId() {
        return cityId;
    }
    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @FormParam("nationId")
    private int nationId;
    public int getNationId() {
        return nationId;
    }
    public void setNationId(int nationId) {
        this.nationId = nationId;
    }

    @FormParam("coordinate")
    private String coordinate;
    public String getCoordinate() {
        return coordinate;
    }
    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

}
