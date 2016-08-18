package com.funliving.info.resource.repr;

import java.util.Date;
import com.funliving.info.repository.entity.College;
import org.apache.solr.client.solrj.beans.Field;

public class CollegeJson {

    public CollegeJson(){}

    public CollegeJson(College entity){
        this.id=entity.getId();
        this.name=entity.getName();
        this.cityId=entity.getCityId();
        this.nation=entity.getNationId();
        this.coordinate = entity.getCoordinate();
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

    @Field("Id")
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Field("College")
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Field("City")
    private int cityId;
    public int getCityId() {
        return cityId;
    }
    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "CollegeJson{" +
                "coordinate='" + coordinate + '\'' +
                ", nation=" + nation +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", cityId=" + cityId +
                '}';
    }
}
