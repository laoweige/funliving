package com.funliving.info.resource.repr;

import java.util.Date;
import com.funliving.info.repository.entity.College;

public class CollegeJson {

    public CollegeJson(){}

    public CollegeJson(College entity){
        this.id=entity.getId();
        this.name=entity.getName();
        this.cityId=entity.getCityId();
    }

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
}
