package com.funliving.info.repository;

import com.funliving.info.repository.entity.Room;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoomRepository {

    @Select("SELECT * FROM apartmentRoom where id = #{id}")
    Room getEntity(int id);

    @Select("SELECT * FROM apartmentRoom  where apartmentId = #{apartmentId}")
    List<Room> getList(@Param("apartmentId") int apartmentId);

    @Insert("insert into apartmentRoom(apartmentId,rent,imprest,status,name,type,toilet," +
            "kitchen,acreage1,acreage2,createTime,bed) " +
            "values(#{apartmentId},#{rent},#{imprest},#{status}," +
            "#{name},#{type},#{toilet},#{kitchen},#{acreage1},#{acreage2},#{createTime},#{bed})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int create(Room apartmentRoom);

    @Update("update apartmentRoom set apartmentId=#{apartmentId}," +
            "images=#{images},rent=#{rent},imprest=#{imprest}," +
            "total=#{total},used=#{used},name=#{name},type=#{type}," +
            "toilet=#{toilet},description=#{description},createTime=#{createTime}," +
            "lastTime=#{lastTime} where id=#{id}")
    void update(Room apartmentRoom);

    @Delete("delete apartmentRoom where id=#{id}")
    void delete(int id);

}
