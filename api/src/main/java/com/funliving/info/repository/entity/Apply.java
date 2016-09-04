package com.funliving.info.repository.entity;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class Apply {
    @Override
    public String toString() {
        return "Apply{" +
                "id=" + id +
                ", userId=" + userId +
                ", createId=" + createId +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birthday='" + birthday + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                ", university='" + university + '\'' +
                ", major='" + major + '\'' +
                ", enterDate='" + enterDate + '\'' +
                ", creditName='" + creditName + '\'' +
                ", creditCard='" + creditCard + '\'' +
                ", creditSecurity='" + creditSecurity + '\'' +
                ", startDate='" + startDate + '\'' +
                ", expireDate='" + expireDate + '\'' +
                ", assureName='" + assureName + '\'' +
                ", assureGender=" + assureGender +
                ", assureRelation='" + assureRelation + '\'' +
                ", assureBirthday='" + assureBirthday + '\'' +
                ", assureMobile='" + assureMobile + '\'' +
                ", assureAddress='" + assureAddress + '\'' +
                ", createTime=" + createTime +
                '}';
    }

    @FormParam("id")
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @FormParam("userId")
    private int userId;
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    @FormParam("createId")
    private int createId;
    public int getCreateId() {
        return createId;
    }
    public void setCreateId(int createId) {
        this.createId = createId;
    }

    @FormParam("name")
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @FormParam("gender")
    private int gender;
    public int getGender() {
        return gender;
    }
    public void setGender(int gender) {
        this.gender = gender;
    }

    @FormParam("birthday")
    private String birthday;


    @FormParam("mobile")
    private String mobile;
    public String getMobile() {
        return mobile;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @FormParam("email")
    private String email;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @FormParam("status")
    private int status;
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    @FormParam("university")
    private String university;
    public String getUniversity() {
        return university;
    }
    public void setUniversity(String university) {
        this.university = university;
    }

    @FormParam("major")
    private String major;
    public String getMajor() {
        return major;
    }
    public void setMajor(String major) {
        this.major = major;
    }

    @FormParam("enterDate")
    private String enterDate;


    @FormParam("creditName")
    private String creditName;
    public String getCreditName() {
        return creditName;
    }
    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }

    @FormParam("creditCard")
    private String creditCard;
    public String getCreditCard() {
        return creditCard;
    }
    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    @FormParam("creditSecurity")
    private String creditSecurity;
    public String getCreditSecurity() {
        return creditSecurity;
    }
    public void setCreditSecurity(String creditSecurity) {
        this.creditSecurity = creditSecurity;
    }

    @FormParam("startDate")
    private String startDate;


    @FormParam("expireDate")
    private String expireDate;


    @FormParam("assureName")
    private String assureName;
    public String getAssureName() {
        return assureName;
    }
    public void setAssureName(String assureName) {
        this.assureName = assureName;
    }

    @FormParam("assureGender")
    private int assureGender;
    public int getAssureGender() {
        return assureGender;
    }
    public void setAssureGender(int assureGender) {
        this.assureGender = assureGender;
    }

    @FormParam("assureRelation")
    private String assureRelation;
    public String getAssureRelation() {
        return assureRelation;
    }
    public void setAssureRelation(String assureRelation) {
        this.assureRelation = assureRelation;
    }

    @FormParam("assureBirthday")
    private String assureBirthday;
    public String getAssureBirthday() {
        return assureBirthday;
    }
    public void setAssureBirthday(String assureBirthday) {
        this.assureBirthday = assureBirthday;
    }

    @FormParam("assureMobile")
    private String assureMobile;
    public String getAssureMobile() {
        return assureMobile;
    }
    public void setAssureMobile(String assureMobile) {
        this.assureMobile = assureMobile;
    }

    @FormParam("assureAddress")
    private String assureAddress;
    public String getAssureAddress() {
        return assureAddress;
    }
    public void setAssureAddress(String assureAddress) {
        this.assureAddress = assureAddress;
    }

    private Date createTime = new Date();
    public Date getCreateTime() {
        return createTime;
    }
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(String enterDate) {
        this.enterDate = enterDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }
}
