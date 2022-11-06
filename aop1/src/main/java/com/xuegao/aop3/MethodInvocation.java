package com.xuegao.aop3;

import java.lang.reflect.Method;

/**
 * @Author wmf
 * @Date 2022/1/19 10:05
 * @Description 信息的格式
 */
public interface MethodInvocation {
    /**
     * 机器的信息
     *
     * @return
     */
    Object getThis();

    /**
     * 方法的信息(杯装还是蛋筒)
     *
     * @return
     */
    Method getMethod();

    /**
     * 客户需求的信息(草莓/原味/巧克力 大/中/小)
     *
     * @return
     */
    Object[] getArguments();

    /**
     * 开始生产标识
     *
     * @return
     * @throws Throwable
     */
    Object proceed() throws Throwable;

}