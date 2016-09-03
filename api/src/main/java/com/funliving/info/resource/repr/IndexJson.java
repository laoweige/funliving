package com.funliving.info.resource.repr;

import com.funliving.info.repository.entity.City;

import java.util.List;

/**
 * Created by Administrator on 2016/9/3.
 */
public class IndexJson {

    List<CollegeJson> colleges;
    List<City> cities;

    public List<CollegeJson> getColleges() {
        return colleges;
    }

    public void setColleges(List<CollegeJson> colleges) {
        this.colleges = colleges;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
