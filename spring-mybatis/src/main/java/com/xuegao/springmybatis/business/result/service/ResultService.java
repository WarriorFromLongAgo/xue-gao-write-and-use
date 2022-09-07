package com.xuegao.springmybatis.business.result.service;

import com.xuegao.springmybatis.business.result.mapper.ResultMapper;
import com.xuegao.springmybatis.model.demo.doo.MybatisResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ResultService {

    @Autowired
    private ResultMapper resultMapper;

    public List<MybatisResult> list() {
        return resultMapper.list();
    }

    public List<Map<String, Object>> listMap() {
        return resultMapper.listMap();
    }
}
