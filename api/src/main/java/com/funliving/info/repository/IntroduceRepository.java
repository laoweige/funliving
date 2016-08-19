package com.funliving.info.repository;

import com.funliving.info.repository.entity.Introduce;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IntroduceRepository {

    @Select("SELECT * FROM introduce where id = #{id}")
    Introduce getEntity(int id);

    @Select("SELECT * FROM introduce  where businessType=#{businessType} AND bussinessId=#{bussinessId}")
    List<Introduce> getList(@Param("businessType") int businessType,
                          @Param("bussinessId") int bussinessId);

    @Insert("insert into introduce(title,digest,content,businessType,bussinessId) " +
            "values(#{title},#{digest},#{content},#{businessType},#{bussinessId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int create(Introduce introduce);

    @Update("update introduce set title=#{title},digest=#{digest}," +
            "content=#{content},businessType=#{businessType}," +
            "bussinessId=#{bussinessId} where id=#{id}")
    void update(Introduce introduce);

    @Delete("delete introduce where id=#{id}")
    void delete(int id);

}
