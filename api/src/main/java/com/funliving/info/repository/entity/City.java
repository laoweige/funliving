package com.funliving.info.repository.entity;

import org.apache.solr.client.solrj.beans.Field;

public class City {

    @Field("Id")
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Field("CityName")
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Field("EnName")
    private String english;
    @Field("SpellLetter")
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

    @Field("Nation")
    private int nationId;
    public int getNationId() {
        return nationId;
    }
    public void setNationId(int nationId) {
        this.nationId = nationId;
    }

}
