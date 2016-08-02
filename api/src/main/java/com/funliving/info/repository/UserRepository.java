package com.funliving.info.repository;


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

    @Select("SELECT * FROM Users")
    List<User> All();

    @Insert("INSERT INTO Users (name,password,email,mobile,status,integral,createTime,loginTime) " +
            "VALUES(#{name},#{password},#{email},#{mobile},#{status},#{integral},#{createTime},#{loginTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void createUser(User user);

}
