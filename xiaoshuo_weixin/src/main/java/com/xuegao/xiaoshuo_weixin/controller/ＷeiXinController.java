package com.xuegao.xiaoshuo_weixin.controller;

import com.alibaba.fastjson2.JSONObject;
import com.xuegao.xiaoshuo_weixin.domain.WechartConst;
import com.xuegao.xiaoshuo_weixin.util.WechatUtil;
import lombok.Getter;
import lombok.Setter;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ＷeiXinController {

    @RequestMapping("/wx")
    public void test() {
        System.out.println("dfjkshfjksdhfjksdhjkfdshjfk");
    }

    @RequestMapping("/get/access_token")
    public void access_token() {
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://api.weixin.qq.com/cgi-bin/token";
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "client_credential");
        params.add("appid", "wx79d197ff367c664c");
        params.add("secret", "bf69353bf9a01a50795597d055aa8fd9");
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        URI uri = builder.queryParams(params).build().encode().toUri();

        String forObject = restTemplate.getForObject(uri, String.class);
        System.out.println(forObject);
//        {"access_token":"75_y4oXIqdFzxT6-vhtH5nXT21iFeus-SuO2PS5-mOcD-x7mLvGQyBHLfrp9MyKjP0kSaba3Z9y8S3D3Us3yWv4QJtChHXTcyGtLSW_W8U4qTllA6AP6cpTgCtUbngUULdAIAHHY","expires_in":7200}
//        {"access_token":"75_63kIaxus1QqRhX-4U8S7JaLo-UideJqCIl2OCanyCI1VL59qlx_fqdRC7eFc-VydKmAQV8fdHjKanisZRHGmfXro3HShaUxFudAjrsVoaSEz_f8CoeBJpCUyG9MUWQaAGADFZ","expires_in":7200}
    }

    @GetMapping("/get/checkToken")
    public String checkToken(WxCheckToken wxCheckToken) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        // get the request
        assert requestAttributes != null;
        HttpServletRequest request = requestAttributes.getRequest();
        String X_Real_Ip = request.getHeader("X-Real-Ip");
        String X_Natapp_Ip = request.getHeader("X-Natapp-Ip");
        System.out.println(X_Real_Ip);
        System.out.println(X_Natapp_Ip);

        boolean b = WechatUtil.checkSignature(wxCheckToken.getSignature(), String.valueOf(wxCheckToken.getTimestamp()), wxCheckToken.getNonce(), wxCheckToken.getEchostr());
        if (b) {
            return wxCheckToken.getEchostr();
        } else {
            throw new RuntimeException("返回错误");
        }
    }

    @Getter
    @Setter
    public static class WxCheckToken {
        private String signature;

        private String echostr;

        private Long timestamp;

        private String nonce;

    }


    @PostMapping("/get/checkToken")
    public String responseEvent(HttpServletRequest req, HttpServletResponse resp) throws IOException, DocumentException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        //把微信返回的xml信息转义成map
        Map<String, String> map = xmlToMap(req);
        String fromUserName = map.get("FromUserName");//消息来源用户标识（一个OpenID）
        String toUserName = map.get("ToUserName");//消息目的用户标识
        String msgType = map.get("MsgType");//消息类型
        String content = map.get("Content");//消息内容
        System.out.println();

        if (msgType.equals(WechartConst.MsgType.EVENT)) {  //事件类型
            String event = map.get("Event");
            if (event.equals(WechartConst.Event.SUBSCRIBE)) { //处理订阅事件
                MessageService.subscribeForText(toUserName, fromUserName);
            } else if (event.equals(WechartConst.Event.UNSUBSCRIBE)) {  //处理取消订阅事件
                MessageService.unsubscribe(toUserName, fromUserName);
            }
        }
        return null;
    }


    /**
     * xml转map
     */
    public Map<String, String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException {
        HashMap<String, String> map = new HashMap<String, String>();
        SAXReader reader = new SAXReader();

        InputStream ins = request.getInputStream();
        Document doc = reader.read(ins);

        Element root = doc.getRootElement();
        @SuppressWarnings("unchecked") List<Element> list = (List<Element>) root.elements();

        for (Element e : list) {
            map.put(e.getName(), e.getText());
        }
        ins.close();
        return map;
    }


}
