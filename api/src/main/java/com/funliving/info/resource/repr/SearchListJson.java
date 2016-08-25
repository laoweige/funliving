package com.funliving.info.resource.repr;

import com.funliving.info.repository.entity.City;
import com.funliving.info.repository.entity.College;

import java.util.List;

/**
 * Created by Administrator on 2016/8/18.
 */
public class SearchListJson {
    private List<SubApartmentJson> apartments;
    private List<CollegeJson> colleges;
    private List<City> cities;
    private long total;
    private CollegeJson college;
    private City city;
    private int page;
    private int endPage;
    private int pageSize;

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public City getCity() {
        return city;
    }

    public CollegeJson getCollege() {
        return college;
    }

    public void setCollege(CollegeJson college) {
        this.college = college;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

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

}
