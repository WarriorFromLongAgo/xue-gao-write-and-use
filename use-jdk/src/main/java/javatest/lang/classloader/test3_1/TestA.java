package javatest.lang.classloader.test3_1;

public class TestA {

    public static void main(String[] args) {
        TestA testA = new TestA();
        testA.hello();
    }

    public void hello() {
        System.out.println("TestA: " + this.getClass().getClassLoader());
        javatest.lang.classloader.test3_1.TestB testB = new TestB();
        testB.hello();
    }
}