package com.funliving.info.repository;

import com.funliving.info.repository.entity.Apartment;
import com.funliving.info.repository.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Administrator on 2016/8/2.
 */
public interface ApartmentRepository {

    @Select("SELECT * FROM Apartment where id = #{id}")
    Apartment getEntity(int id);

    @Insert("INSERT INTO Apartment (name,images,address,serialNumber,rent,currency,city," +
            "coordinate,nation,description,createTime,lastTime) " +
            "VALUES(#{name},#{images},#{address},#{serialNumber},#{rent},#{currency},#{city}," +
            "#{coordinate},#{nation},#{description},#{createTime},#{lastTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int create(Apartment apartment);

}
