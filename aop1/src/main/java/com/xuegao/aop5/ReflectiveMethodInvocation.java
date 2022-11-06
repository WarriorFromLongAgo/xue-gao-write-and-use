package com.xuegao.aop5;

import com.xuegao.aop3.MethodInterceptor;
import com.xuegao.aop3.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @Author wmf
 * @Date 2022/1/17 18:05
 * @Description 调度员本身就是一个打包信息，所以继承了MethodInvocation，自己重新实现了proceed
 */
public class ReflectiveMethodInvocation implements MethodInvocation {

    private Object target;

    private Method method;

    private Object[] args;

    /**
     * 拦截计划列表
     */
    List<MethodInterceptor> chain;

    private int index = -1;

    public ReflectiveMethodInvocation(Object target, Method method, Object[] args, List<MethodInterceptor> chain) {
        this.target = target;
        this.method = method;
        this.args = args;
        this.chain = chain;
    }

    @Override
    public Method getMethod() {
        return this.method;
    }

    @Override
    public Object[] getArguments() {
        return args;
    }

    @Override
    public Object proceed() throws Throwable {
        Object re;
        if (index == chain.size() - 1) {
            re = method.invoke(target, args);
        } else {
            re = chain.get(++index).invoke(this);
        }
        return re;
    }

    @Override
    public Object getThis() {
        return target;
    }

    // @Override
    public AccessibleObject getStaticPart() {
        return null;
    }
}