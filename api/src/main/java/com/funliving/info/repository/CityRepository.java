package com.funliving.info.repository;

import com.funliving.info.repository.entity.City;
import org.apache.ibatis.annotations.*;
import java.util.List;

public interface CityRepository {

    @Select("SELECT * FROM city where id = #{id}")
    City getEntity(int id);

    @Select("SELECT * FROM city")
    List<City> getAll();

    @Select("SELECT * FROM city where nationId= #{nationId}")
    List<City> getList(@Param("nationId") int nationId);

    @Insert("insert into city(name,english,letter,nationId) values(#{name},#{english},#{letter},#{nationId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int create(City city);

    @Update("update city set name=#{name},english=#{english},letter=#{letter},nationId=#{nationId} where id=#{id}")
    int update(City city);

    @Delete("delete city where id=#{id}")
    int delete(int id);

}