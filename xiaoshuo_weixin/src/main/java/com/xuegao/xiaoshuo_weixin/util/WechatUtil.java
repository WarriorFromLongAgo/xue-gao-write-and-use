package com.xuegao.xiaoshuo_weixin.util;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.Arrays;

public class WechatUtil {
    /**
     * 验证消息的确来自微信服务器
     *
     * @param msgSignature 微信加密签名
     * @param token        开发者填写的token参数
     * @param timeStamp    时间戳
     * @param nonce        随机数
     * @return
     * @throws
     */
    public static boolean checkSignature(String signature, String timestamp, String nonce, String echostr) {
        String wxToken = "xuegao";

        //放入数组，进行字典排序后组成一个字符串。
        String[] arr = new String[]{wxToken, timestamp, nonce};
        Arrays.sort(arr);
        String str = arr[0] + arr[1] + arr[2];
        //sha1加密，这里可以手写也可以用jar包，我选择用jar包，具体的maven依赖在该系列文章的第一章里。
        //如果选择手写，可以参考第三段的代码段。

        String resultMsg = DigestUtils.sha1Hex(str);
        return resultMsg.equals(signature);
    }
}
