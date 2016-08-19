package com.funliving.info.repository.entity;


public class Introduce {
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    private String title;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    private String digest;
    public String getDigest() {
        return digest;
    }
    public void setDigest(String digest) {
        this.digest = digest;
    }

    private String content;
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
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
