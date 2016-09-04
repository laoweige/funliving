package com.funliving.info.repository;

import org.apache.ibatis.annotations.*;
import java.util.List;

import com.funliving.info.repository.entity.Apply;

public interface ApplyRepository {

    @Select("SELECT * FROM apply where userId = #{id}")
    Apply getEntity(int id);

    @Select("SELECT * FROM apply  where createId = #{id}")
    List<Apply> getList(int id);

    @Select("SELECT * FROM apply order by id desc LIMIT #{start},30")
    List<Apply> getListByPage(@Param("start") int start);

    @Insert("insert into apply(userId,createId,name,gender," +
            "birthday,mobile,email,status,university,major,enterDate," +
            "creditName,creditCard,creditSecurity,startDate," +
            "expireDate,assureName,assureGender,assureRelation," +
            "assureBirthday,assureMobile,assureAddress,createTime) " +
            "values(#{userId},#{createId},#{name},#{gender},#{birthday}," +
            "#{mobile},#{email},#{status},#{university},#{major}," +
            "#{enterDate},#{creditName},#{creditCard},#{creditSecurity}," +
            "#{startDate},#{expireDate},#{assureName},#{assureGender},#{assureRelation}," +
            "#{assureBirthday},#{assureMobile},#{assureAddress},#{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int create(Apply apply);

    @Update("update apply set userId=#{userId},createId=#{createId}," +
            "name=#{name},gender=#{gender},birthday=#{birthday}," +
            "mobile=#{mobile},email=#{email},status=#{status},university=#{university}," +
            "major=#{major},enterDate=#{enterDate},creditName=#{creditName}," +
            "creditCard=#{creditCard},creditSecurity=#{creditSecurity}," +
            "startDate=#{startDate},expireDate=#{expireDate},assureName=#{assureName}," +
            "assureGender=#{assureGender},assureRelation=#{assureRelation}," +
            "assureBirthday=#{assureBirthday},assureMobile=#{assureMobile}," +
            "assureAddress=#{assureAddress},createTime=#{createTime} where id=#{id}")
    int update(Apply apply);

    @Delete("delete apply where id=#{id}")
    void delete(int id);

}