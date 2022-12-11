package javatest.util.serviceloader;

public class LoaderA implements ILoader{
    @Override
    public void sayHello() {
        System.out.println("Hello, I am LoaderA");
    }
}
