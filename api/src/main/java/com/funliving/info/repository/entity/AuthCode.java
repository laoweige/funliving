package com.funliving.info.repository.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.ws.rs.FormParam;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;


@XmlRootElement
public class AuthCode {
    public AuthCode(){}


    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @FormParam("id")
    private int id;

    @FormParam("mobile")
    private String mobile;

    @FormParam("code")
    private int code;

//    @FormParam("sendTime")
    private Date sendTime = new Date();

    private int total;

    private Date createTime = new Date();
}
