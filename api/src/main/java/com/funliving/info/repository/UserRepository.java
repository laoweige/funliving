package com.funliving.info.repository;


import com.funliving.info.repository.entity.AuthCode;
import com.funliving.info.repository.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

public interface UserRepository {

    @Select("SELECT * FROM Users where mobile=#{mobile} and password=#{password} LIMIT 0,1")
    User login(@Param("mobile") String mobile,
               @Param("password") String password);


    @Insert("INSERT INTO Users (name,password,email,mobile,status,createTime,loginTime) " +
            "VALUES(#{name},#{password},#{email},#{mobile},#{status},#{createTime},#{loginTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int createUser(User user);

    @Insert("INSERT INTO AuthCode (mobile,code,total,createTime,sendTime) " +
            "VALUES(#{mobile},#{code},#{total},#{createTime},#{sendTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int addCode(AuthCode authCode);

    @Select("SELECT * FROM AuthCode where mobile=#{mobile} order by id desc LIMIT 0,1")
    AuthCode queryCode(@Param("mobile") String mobile);

    @Insert("update AuthCode set total=total+1,sendTime=#{sendTime} where id=#{id}")
    int updateCode(AuthCode authCode);


}
