package com.funliving.info.repository;

import com.funliving.info.repository.entity.Schedule;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

/**
 * Created by weizhigang on 16/9/2.
 */
public interface ScheduleRepository {

    @Select("SELECT * FROM Schedule where id = #{id}")
    Schedule getEntity(int id);

    @Insert("insert into Schedule(userId,status,name,mobile,email," +
            "startTime,endTime,createTime) " +
            "values(#{userId},#{status},#{name},#{mobile}," +
            "#{email},#{startTime},#{endTime},#{createTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int create(Schedule apartmentRoom);


}
