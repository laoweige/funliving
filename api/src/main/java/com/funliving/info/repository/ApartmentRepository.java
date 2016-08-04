package com.funliving.info.repository;

import com.funliving.info.repository.entity.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ApartmentRepository {

    @Select("SELECT * FROM apartment where id = #{id}")
    Apartment getEntity(int id);

    @Insert("insert into apartment(name,images,address," +
            "serialNumber,rent,currency,city,coordinate,nation," +
            "description,createTime,lastTime) values(#{name},#{images},#{address}," +
            "#{serialNumber},#{rent},#{currency},#{city},#{coordinate},#{nation}," +
            "#{description},#{createTime},#{lastTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int create(Apartment apartment);

    @Update("update apartment set name=#{name},images=#{images},address=#{address}," +
            "serialNumber=#{serialNumber},rent=#{rent},currency=#{currency}," +
            "city=#{city},coordinate=#{coordinate},nation=#{nation}," +
            "description=#{description},createTime=#{createTime}," +
            "lastTime=#{lastTime} where id=#{id}")
    int update(Apartment apartment);

    @Delete("delete apartment where id=#{id}")
    int delete(int id);

    @Select("SELECT * FROM ApartmentRoom where apartmentId = #{apartmentId}")
    List<Room> getRooms(int apartmentId);

    @Select("SELECT * FROM ApartmentFacility where apartmentId = #{apartmentId}")
    List<Facility> getFacilities(int apartmentId);

    @Select("SELECT * FROM ApartmentDistance where apartmentId = #{apartmentId} and schoolId=#{schoolId}")
    Distance getDistance(@Param("apartmentId") int apartmentId,@Param("schoolId") int schoolId);









}
