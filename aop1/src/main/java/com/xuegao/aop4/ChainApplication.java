package com.xuegao.aop4;

import com.xuegao.aop.IceCreamMachine;
import com.xuegao.aop.IceCreamMachine1;
import com.xuegao.aop3.MethodInterceptor;
import com.xuegao.aop3.MethodInvocation;

public class ChainApplication {
    public static void main(String[] args) {
        // 厂家的冰淇淋机
        IceCreamMachine machine = new IceCreamMachine1();
        // 厂家定制食品监督计划
        MethodInterceptor interceptor1 = new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                System.out.println("记录需求至食品监督本：" + invocation.getArguments()[0]);
                Object proceed = invocation.proceed();
                System.out.println("拍照传给厂家微信：" + proceed);
                return proceed;
            }
        };
        // 厂家定制市场调研计划
        MethodInterceptor interceptor2 = new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                System.out.println("记录需求至市场调研本：" + invocation.getArguments()[0]);
                return invocation.proceed();
            }
        };
        // 代理公司
        ProxyCompanyV2 proxyCompany = new ProxyCompanyV2();
        // 绑定冰淇淋机
        proxyCompany.setTarget(machine);
        // 绑定两个拦截计划
        proxyCompany.addInterceptor(interceptor1);
        proxyCompany.addInterceptor(interceptor2);
        // 生成售货员(机器的代理)
        IceCreamMachine saler = (IceCreamMachine) proxyCompany.getProxy();
        String iceCream = saler.eggCone("原味", "中");

        // 记录需求至食品监督本：原味
        // 记录需求至市场调研本：原味
        // 开始生产蛋筒冰淇淋
        // 拍照传给厂家微信：原味 蛋筒冰淇淋(中)

    }
}