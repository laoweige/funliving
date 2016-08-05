package com.funliving.info.repository;

import com.funliving.info.repository.entity.City;
import org.apache.ibatis.annotations.*;
import java.util.List;

public interface CityRepository {

    @Select("SELECT * FROM city where id = #{id}")
    City getEntity(int id);

    @Select("SELECT * FROM city")
    List<City> getList();

    @Insert("insert into city(name,nationId) values(#{id},#{name})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int create(City city);

    @Update("update city set name=#{name},nationId=#{nationId} where id=#{id}")
    int update(City city);

    @Delete("delete city where id=#{id}")
    int delete(int id);

}