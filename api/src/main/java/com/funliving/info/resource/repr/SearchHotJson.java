package com.funliving.info.resource.repr;

import com.funliving.info.repository.entity.City;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/9.
 */
public class SearchHotJson {
    private List<HotJson> apartments = new ArrayList<>();
    private List<HotJson>  colleges = new ArrayList<>();
    private List<HotJson> cities = new ArrayList<>();

    public List<HotJson> getApartments() {
        return apartments;
    }

    public void setApartments(List<HotJson> apartments) {
        this.apartments = apartments;
    }

    public List<HotJson> getColleges() {
        return colleges;
    }

    public void setColleges(List<HotJson> colleges) {
        this.colleges = colleges;
    }

    public List<HotJson> getCities() {
        return cities;
    }

    public void setCities(List<HotJson> cities) {
        this.cities = cities;
    }
}
