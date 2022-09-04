package javatest.lang.classloader.test1;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class MyClassloader {
    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, IllegalAccessException, MalformedURLException {

        ClassLoader loader1 = new URLClassLoader(new URL[]{new URL("file:javatest/lang/classloader/test1/One.java")}, MyClassloader.class.getClassLoader());
        ClassLoader loader2 = new URLClassLoader(new URL[]{new URL("file:javatest/lang/classloader/test1/Two.java")}, MyClassloader.class.getClassLoader());

        String className = "javatest.lang.classloader.test1";
        // loader1
        System.out.print("One.jar \t");
        Class clazz1 = Class.forName(className, true, loader1);
        clazz1.getMethod("main", String[].class).invoke(null, (Object) null);

        System.out.println();

        // loader2
        System.out.print("Two.jar \t");
        Class clazz2 = Class.forName(className, true, loader2);
        clazz2.getMethod("main", String[].class).invoke(null, (Object) null);

        System.out.println();

        System.out.println("实例化后是否相等：" + clazz1.equals(clazz2));
    }
}
