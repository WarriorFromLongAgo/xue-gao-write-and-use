package com.xuegao.baiduai.http;

import com.alibaba.fastjson2.JSONObject;
import com.xuegao.util.JsonUtil;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Sample {
    private static final Logger log = LoggerFactory.getLogger(Sample.class);

    public static final String API_KEY = "GFMdBUXUBBW1pa4qSXVG60GM";
    public static final String SECRET_KEY = "a1WdmhZyqgNdUrSWyF8ktx941lMcHRnR";

    final OkHttpClient HTTP_CLIENT = new OkHttpClient().newBuilder().build();

    public String asdadadaa() throws IOException {
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"text\":\"五小教育集团学生\\\"十提倡\\\".准时准点到学校,早餐在家要吃饱.到校早读记入脑,经常要把卫生搞.下课放松不能少,书包课桌整理好.听课认真笔记巧,遇到问题要思考.楼道慢步不打闹,礼让他人问个好.安全知识要记牢,珍惜生命最重要.放学路队诵读妙,两点一线不抢秒.节约用水要做到,花草树木视如宝.远离手机把眼保,早睡早起身体好.立志报国趁年少,强国有我真自豪.\",\"voice\":111,\"lang\":\"zh\"}");
        Request request = new Request.Builder()
                .url("https://aip.baidubce.com/rpc/2.0/tts/v1/create?access_token=" + getAccessToken())
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        Response response = HTTP_CLIENT.newCall(request).execute();
        String string = response.body().string();
        JSONObject jsonObject = JsonUtil.toClass(string, JSONObject.class);
        log.info("[xue-gao-write-and-use][Sample][asdadadaa][jsonObject={}]", jsonObject);
        return jsonObject.getString("task_id");
    }

    public void after(String taskId) throws IOException {
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "{\"task_ids\":\"" + taskId + "\"}");
        Request request = new Request.Builder()
                .url("https://aip.baidubce.com/rpc/2.0/tts/v1/query?access_token=" + getAccessToken())
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Accept", "application/json")
                .build();
        Response response = HTTP_CLIENT.newCall(request).execute();
        System.out.println(response.body().string());
    }


    /**
     * 从用户的AK，SK生成鉴权签名（Access Token）
     *
     * @return 鉴权签名（Access Token）
     * @throws IOException IO异常
     */
    public String getAccessToken() throws IOException {
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "grant_type=client_credentials&client_id=" + API_KEY
                + "&client_secret=" + SECRET_KEY);
        Request request = new Request.Builder()
                .url("https://aip.baidubce.com/oauth/2.0/token")
                .method("POST", body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        Response response = HTTP_CLIENT.newCall(request).execute();
        ResponseBody responseBody = response.body();
        log.info("[xue-gao-write-and-use][Sample][getAccessToken][={}]", JsonUtil.toJsonString(responseBody));
        String string = responseBody.string();
        JSONObject jsonObject = JsonUtil.toClass(string, JSONObject.class);
        return jsonObject.getString("access_token");
    }

}