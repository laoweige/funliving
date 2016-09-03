package com.funliving.info.repository.entity;

import org.apache.solr.client.solrj.beans.Field;

import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class College {

    @Field("Id")
    @FormParam("id")
    private int id;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Field("College")
    @FormParam("name")
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Field("City")
    @FormParam("cityId")
    private int cityId;
    public int getCityId() {
        return cityId;
    }
    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Field("Nation")
    @FormParam("nationId")
    private int nationId;
    public int getNationId() {
        return nationId;
    }
    public void setNationId(int nationId) {
        this.nationId = nationId;
    }

    @Field("Coordinate")
    @FormParam("coordinate")
    private String coordinate;
    public String getCoordinate() {
        return coordinate;
    }
    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    @Field("EnName")
    @FormParam("english")
    private String english;
    @Field("SpellLetter")
    @FormParam("letter")
    private String letter;

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

}
