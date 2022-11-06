package com.xuegao.aop3;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author wmf
 * @Date 2022/1/12 18:23
 * @Description 代理公司
 */
public class ProxyCompany implements AopProxy, InvocationHandler { // AopProxy相当于国家给所有代理公司下发的一个标准

    public ProxyCompany() {
    }

    /**
     * 设置拦截计划
     *
     * @param interceptor
     */
    public void setInterceptor(MethodInterceptor interceptor) {
        this.interceptor = interceptor;
    }

    /**
     * 绑定冰淇淋机
     *
     * @param target
     */
    public void setTarget(Object target) {
        this.target = target;
    }

    /**
     * 附加工作
     */
    MethodInterceptor interceptor;
    /**
     * 冰淇淋机
     */
    Object target;

    /**
     * 生成售货员(代理)
     *
     * @return
     */
    @Override
    public Object getProxy() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object getProxy(ClassLoader classLoader) {
        return null;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 准备上下文
        MethodInvocation invocation = new MethodInvocation() {
            @Override
            public Method getMethod() {
                return method;
            }

            @Override
            public Object[] getArguments() {
                return args;
            }

            @Override
            public Object proceed() throws Throwable {
                return method.invoke(target, args);
            }

            @Override
            public Object getThis() {
                return target;
            }

            public AccessibleObject getStaticPart() {
                return null;
            }
        };
        // 需求来了之后按拦截计划去执行
        return interceptor.invoke(invocation);
    }
}