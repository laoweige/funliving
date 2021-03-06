package com.funliving.info.repository;

import org.apache.ibatis.annotations.*;
import java.util.List;

import com.funliving.info.repository.entity.College;

public interface CollegeRepository {

    @Select("SELECT * FROM college where id = #{id}")
    College getEntity(int id);

    @Select("SELECT * FROM college LIMIT 0,18")
    List<College> getAll();

    @Select("SELECT * FROM college where cityId = #{cityId}")
    List<College> getList(@Param("cityId") int cityId);

    @Insert("insert into college(name,english,letter,cityId,nationId,coordinate) " +
            "values(#{name},#{english},#{letter},#{cityId},#{nationId},#{coordinate})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int create(College college);

    @Update("update college set name=#{name},english=#{english},letter=#{letter}," +
            "cityId=#{cityId},nationId=#{nationId}," +
            "coordinate=#{coordinate} where id=#{id}")
    int update(College college);

    @Delete("delete college where id=#{id}")
    int delete(int id);
}