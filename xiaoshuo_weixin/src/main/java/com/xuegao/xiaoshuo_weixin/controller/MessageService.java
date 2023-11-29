package com.xuegao.xiaoshuo_weixin.controller;

/**
 * 微信推送消息事件处理类
 */
public class MessageService {
    
        /*
         * 响应订阅事件
         */
        public static void subscribeForText(String toUserName,String fromUserName){
        	 System.out.println("用户："+ fromUserName +"关注了公众号");
        }

        /*
         * 响应取消订阅事件
         */
        public static void unsubscribe(String toUserName,String fromUserName){
          	//可以进行取关后的其他后续业务处理
            System.out.println("用户："+ fromUserName +"取消关注~");
        }

    }

