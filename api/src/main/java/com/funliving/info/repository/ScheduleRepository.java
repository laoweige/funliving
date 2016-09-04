package com.funliving.info.repository;

import com.funliving.info.repository.entity.Schedule;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by weizhigang on 16/9/2.
 */
public interface ScheduleRepository {

    @Select("SELECT * FROM Schedule where id = #{id}")
    Schedule getEntity(int id);

    @Select("SELECT * FROM schedule  where userId = #{id}")
    List<Schedule> getList(int id);

    @Select("SELECT * FROM schedule order by id desc LIMIT #{start},30")
    List<Schedule> getListByPage(@Param("start") int start);

    @Insert("insert into Schedule(userId,status,name,mobile,email," +
            "startTime,endTime,createTime,apartmentId,roomId) " +
            "values(#{userId},#{status},#{name},#{mobile}," +
            "#{email},#{startTime},#{endTime},#{createTime},#{apartmentId},#{roomId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int create(Schedule apartmentRoom);

    @Update("update schedule set name=#{name}," +
            "mobile=#{mobile},email=#{email},status=#{status}," +
            "apartmentId=#{apartmentId},roomId=#{roomId}," +
            "startTime=#{startTime},endTime=#{endTime},createTime=#{createTime} " +
            "where id=#{id}")
    void update(Schedule schedule);

    @Delete("delete schedule where id=#{id}")
    void delete(int id);


}
