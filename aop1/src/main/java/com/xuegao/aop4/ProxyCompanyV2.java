package com.xuegao.aop4;

import com.xuegao.aop3.AopProxy;
import com.xuegao.aop3.MethodInterceptor;
import com.xuegao.aop3.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author wmf
 * @Date 2022/1/12 18:23
 * @Description 代理公司
 */
public class ProxyCompanyV2 implements AopProxy, InvocationHandler { // AopProxy相当于国家给所有代理公司下发的一个标准

    public ProxyCompanyV2() {
    }

    /**
     * (改)添加拦截计划
     *
     * @param interceptor
     */
    public void addInterceptor(MethodInterceptor interceptor) {
        this.interceptors.add(interceptor);
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
     * (改)附加工作列表
     */
    List<MethodInterceptor> interceptors = new ArrayList<>();
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
        // 打包的信息 上面提到过
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

            // @Override
            public AccessibleObject getStaticPart() {
                return null;
            }
        };
        // (改)召唤一个调度员
        Dispatcher dispatcher = new Dispatcher(invocation, interceptors);
        // (改)需求来了之后让调度员去执行
        return dispatcher.proceed();
    }
}