package javatest.lang.classloader.test3;

import javatest.lang.classloader.test3_1.TestB;

public class TestA {

    public static void main(String[] args) {
        javatest.lang.classloader.test3_1.TestA testA = new javatest.lang.classloader.test3_1.TestA();
        testA.hello();
    }

    public void hello() {
        System.out.println("TestA: " + this.getClass().getClassLoader());
        javatest.lang.classloader.test3_1.TestB testB = new TestB();
        testB.hello();
    }
}