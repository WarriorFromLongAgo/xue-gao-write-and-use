package javatest.util.serviceloader;

import java.util.Iterator;
import java.util.ServiceLoader;

public class ServiceLoaderTest1 {
    public static void main(String[] args) {
        loadTest1();
        // Hello, I am LoaderA
        // Hello, I am LoaderB
        System.out.println("=============================================");
        loadTest2();
        // Hello, I am LoaderA
        // Hello, I am LoaderB

    }

    public static void loadTest1() {
        ILoader loaderA = new LoaderA();
        loaderA.sayHello();

        ILoader loaderB = new LoaderB();
        loaderB.sayHello();

    }

    public static void loadTest2() {
        ServiceLoader<ILoader> loaderA = ServiceLoader.load(ILoader.class);
        Iterator<ILoader> loaderAIterator = loaderA.iterator();
        //循环获取所需的对象
        while (loaderAIterator.hasNext()) {
            ILoader next = loaderAIterator.next();
            next.sayHello();
        }
        // Hello, I am LoaderA
        // Hello, I am LoaderB

        ServiceLoader<LoaderA> loaderAA = ServiceLoader.load(LoaderA.class);
        Iterator<LoaderA> loaderAAIterator = loaderAA.iterator();
        //循环获取所需的对象
        while (loaderAAIterator.hasNext()) {
            ILoader next = loaderAAIterator.next();
            next.sayHello();
        }

        ServiceLoader<LoaderB> loaderB = ServiceLoader.load(LoaderB.class);
        Iterator<LoaderB> loaderBIterator = loaderB.iterator();
        //循环获取所需的对象
        while (loaderBIterator.hasNext()) {
            ILoader next = loaderBIterator.next();
            next.sayHello();
        }

    }
}
