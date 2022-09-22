package javatest.lang.reflect.invocationHandler.test1;

import java.lang.reflect.Method;

public class UseProxy implements MyInvocationHandler {
    private Object target;
    public Object myJDKProxy(Object target){
        this.target = target;
        Class<?> clazz =  target.getClass();
        return MyProxy.newProxyInstance(new MyClassLoader(),clazz.getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理user，执行shopping()开始...");
        Object result = method.invoke(this.target, args);
        System.out.println("代理user，执行shopping()结束...");
        return result;
    }
}