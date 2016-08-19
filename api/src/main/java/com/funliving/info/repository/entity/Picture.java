package com.funliving.info.repository.entity;


public class Picture {

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

    private String path;
    public String getPath() {
        return path;
    }
    public void setPath(String path) {
        this.path = path;
    }

    private int businessType;
    public int getBusinessType() {
        return businessType;
    }
    public void setBusinessType(int businessType) {
        this.businessType = businessType;
    }

    private int bussinessId;
    public int getBussinessId() {
        return bussinessId;
    }
    public void setBussinessId(int bussinessId) {
        this.bussinessId = bussinessId;
    }

}