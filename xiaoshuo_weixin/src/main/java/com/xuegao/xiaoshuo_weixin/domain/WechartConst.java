package com.xuegao.xiaoshuo_weixin.domain;

public class WechartConst {
	  /**
	     * 消息类型
	     */
	    public class MsgType {
	        public static final String TEXT = "text";
	        public static final String EVENT = "event";
	    }
	
	    /**
	     * 事件类型
	     */
	    public class Event {
	        public static final String SUBSCRIBE = "subscribe";//订阅事件
	        public static final String UNSUBSCRIBE = "unsubscribe";//取消订阅事件
	    }
    }
