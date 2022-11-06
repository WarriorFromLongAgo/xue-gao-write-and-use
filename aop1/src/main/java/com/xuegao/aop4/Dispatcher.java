package com.xuegao.aop4;

import com.xuegao.aop3.MethodInterceptor;
import com.xuegao.aop3.MethodInvocation;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @Author wmf
 * @Date 2022/1/19 13:59
 * @Description 调度员
 */
public class Dispatcher {
    /**
     * 原打包信息
     */
    private MethodInvocation methodInvocation;
    /**
     * 调包后的打包的信息
     */
    private MethodInvocation changelingMethodInvocation;
    /**
     * 拦截计划列表
     */
    private List<MethodInterceptor> chain;

    /**
     * 执行拦截计划的游标
     */
    private Integer index = -1;

    public Dispatcher(MethodInvocation methodInvocation, List<MethodInterceptor> chain) throws Throwable {
        this.chain = chain;
        Dispatcher that = this;
        // 存储调度员原打包的信息
        this.methodInvocation = methodInvocation;
        // 调包打包信息里面的开始按钮
        this.changelingMethodInvocation = new MethodInvocation() {
            @Override
            public Object getThis() {
                return methodInvocation.getThis();
            }

            // 不管
            // @Override
            public AccessibleObject getStaticPart() {
                return null;
            }

            @Override
            public Method getMethod() {
                return methodInvocation.getMethod();
            }

            @Override
            public Object[] getArguments() {
                return methodInvocation.getArguments();
            }

            /** 调包开始按钮，工作执行计划的开始按钮实际上指向调度员的proceed**/
            @Override
            public Object proceed() throws Throwable {
                return that.proceed();
            }
        };
    }

    /**
     * 调度员的工作
     *
     * @return
     * @throws Throwable
     */
    public Object proceed() throws Throwable {
        Object re;
        // 最后一次，没有拦截计划了，开始生产冰淇淋
        if (index == chain.size() - 1) {
            re = methodInvocation.proceed();
        } else { // 还有下一个拦截计划，继续按照下一个拦截计划执行
            re = chain.get(++index).invoke(changelingMethodInvocation);
        }
        return re;
    }
}