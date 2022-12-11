package javatest.util.serviceloader;

public class LoaderB implements ILoader {
    @Override
    public void sayHello() {
        System.out.println("Hello, I am LoaderB");
    }
}
