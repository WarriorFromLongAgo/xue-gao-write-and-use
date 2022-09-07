package com.xuegao.springmybatis.business.result.mapper;

import com.xuegao.springmybatis.model.demo.doo.MybatisResult;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ResultMapper {

    List<MybatisResult> list();

    @MapKey("id")
    List<Map<String, Object>> listMap();

}
