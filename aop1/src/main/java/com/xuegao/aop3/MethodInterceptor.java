package com.xuegao.aop3;

@FunctionalInterface
public interface MethodInterceptor {
	Object invoke(MethodInvocation invocation) throws Throwable;
}