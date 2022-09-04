package javatest.lang.classloader.test3_1;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MyClassLoaderCustom extends ClassLoader {
    private ClassLoader jdkClassLoader;
    private Map<String, String> classPathMap = new HashMap<>();

    public MyClassLoaderCustom(ClassLoader jdkClassLoader) {
        this.jdkClassLoader = jdkClassLoader;
        classPathMap.put("javatest.lang.classloader.test3_1.TestA", "E:\\GitProject\\TestProject\\xue-gao-write-and-use\\use-jdk\\target\\classes\\javatest\\lang\\classloader\\test3_1\\TestA.class");
        classPathMap.put("javatest.lang.classloader.test3_1.TestB", "E:\\GitProject\\TestProject\\xue-gao-write-and-use\\use-jdk\\target\\classes\\javatest\\lang\\classloader\\test3_1\\TestB.class");
    }

    // 重写了 findClass 方法
    @Override
    public Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class result = null;
        try {
            //这里要使用 JDK 的类加载器加载 java.lang 包里面的类
            result = jdkClassLoader.loadClass(name);
        } catch (Exception e) {
            //忽略
        }
        if (result != null) {
            return result;
        }
        String classPath = classPathMap.get(name);
        File file = new File(classPath);
        if (!file.exists()) {
            throw new ClassNotFoundException();
        }

        byte[] classBytes = getClassData(file);
        if (classBytes == null || classBytes.length == 0) {
            throw new ClassNotFoundException();
        }
        return defineClass(classBytes, 0, classBytes.length);
    }

    private byte[] getClassData(File file) {
        try (InputStream ins = new FileInputStream(file); ByteArrayOutputStream baos = new
                ByteArrayOutputStream()) {
            byte[] buffer = new byte[4096];
            int bytesNumRead = 0;
            while ((bytesNumRead = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesNumRead);
            }
            return baos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[]{};
    }
}