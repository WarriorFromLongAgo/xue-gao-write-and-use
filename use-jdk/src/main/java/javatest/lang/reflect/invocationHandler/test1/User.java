package javatest.lang.reflect.invocationHandler.test1;

public class User implements IUser {
    @Override
    public void shopping() {
        System.out.println("user shopping....");
    }

    @Override
    public Double expenses() {
        return 50.5;
    }
}