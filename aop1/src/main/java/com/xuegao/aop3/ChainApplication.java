package com.xuegao.aop3;

import com.xuegao.aop.IceCreamMachine;
import com.xuegao.aop.IceCreamMachine1;

public class ChainApplication {
	public static void main(String[] args) {
		// 厂家的冰淇淋机
		IceCreamMachine machine = new IceCreamMachine1();
		// 厂家定制拦截计划
		MethodInterceptor interceptor = new MethodInterceptor() {
			@Override
			public Object invoke(MethodInvocation invocation) throws Throwable {
				System.out.println("记录需求："+invocation.getArguments()[0]);
				Object proceed = invocation.proceed();
				System.out.println("对生产出的冰淇淋拍照"+proceed);
				return proceed;
			}
		};
		// 代理公司
		ProxyCompany proxyCompany = new ProxyCompany();
		// 绑定冰淇淋机到代理公司
		proxyCompany.setTarget(machine);
		// 绑定拦截计划到代理公司
		proxyCompany.setInterceptor(interceptor);
		// 生成售货员(机器的代理)
		IceCreamMachine saler = (IceCreamMachine) proxyCompany.getProxy();
		String iceCream = saler.eggCone("原味", "中");
		System.out.println("客户拿到冰淇淋："+iceCream);
	}
}