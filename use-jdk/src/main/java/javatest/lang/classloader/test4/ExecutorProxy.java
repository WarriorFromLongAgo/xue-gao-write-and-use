package javatest.lang.classloader.test4;

import java.lang.reflect.Method;

public class ExecutorProxy implements Executor {
    private String version;
    private StandardExecutorClassLoader classLoader;

    public ExecutorProxy(String version) {
        this.version = version;
        classLoader = new StandardExecutorClassLoader(version);
    }

    @Override
    public void execute(String name) {
        try {
            // Load ExecutorProxy class
            Class<?> executorClazz = classLoader.loadClass("Executor" + version.toUpperCase());

            Object executorInstance = executorClazz.newInstance();
            Method method = executorClazz.getMethod("execute", String.class);

            method.invoke(executorInstance, name);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}