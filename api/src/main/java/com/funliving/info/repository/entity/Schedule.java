package com.funliving.info.repository.entity;

import org.omg.CORBA.PRIVATE_MEMBER;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class Schedule {

    @FormParam("id")
    private int id;
    @FormParam("userId")
    private int userId;
    @FormParam("status")
    private int status;
    @FormParam("name")
    private String name;
    @FormParam("email")
    private String email;
    @FormParam("mobile")
    private String mobile;
    @FormParam("startTime")
    private String startTime;
    @FormParam("endTime")
    private String endTime;
    @FormParam("apartmentId")
    private int apartmentId;
    @FormParam("roomId")
    private int roomId;

    public int getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(int apartmentId) {
        this.apartmentId = apartmentId;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    private Date createTime = new Date();



    public int getId() {
        return id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getEmail() {
        return email;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
