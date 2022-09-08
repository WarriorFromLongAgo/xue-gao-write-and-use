package com.xuegao.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class ParseObjectTest {
    public static void main(String[] args) {

        String param = "{\"pageSize\":1000,\"endId\":10000}";
        JSONObject jsonObject = JSON.parseObject(param, JSONObject.class);
        System.out.println(jsonObject);

    }
}
