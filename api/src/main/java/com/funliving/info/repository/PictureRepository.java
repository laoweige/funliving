package com.funliving.info.repository;

import org.apache.ibatis.annotations.*;
import java.util.List;

import com.funliving.info.repository.entity.Picture;

public interface PictureRepository {

    @Select("SELECT * FROM picture where id = #{id}")
    Picture getEntity(int id);

    @Select("SELECT * FROM picture  where businessType=#{businessType} AND bussinessId=#{bussinessId}")
    List<Picture> getList(@Param("businessType") int businessType,
                          @Param("bussinessId") int bussinessId);

    @Insert("insert into picture(name,path,businessType,bussinessId) " +
            "values(#{name},#{path},#{businessType},#{bussinessId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int create(Picture picture);

    @Update("update picture set name=#{name},path=#{path}," +
            "businessType=#{businessType},bussinessId=#{bussinessId} where id=#{id}")
    void update(Picture picture);

    @Delete("delete picture where id=#{id}")
    void delete(int id);
}