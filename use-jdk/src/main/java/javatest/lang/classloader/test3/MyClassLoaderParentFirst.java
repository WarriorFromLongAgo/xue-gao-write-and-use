package javatest.lang.classloader.test3;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MyClassLoaderParentFirst extends ClassLoader {

    private Map<String, String> classPathMap = new HashMap<>();

    public MyClassLoaderParentFirst() {
        classPathMap.put("javatest.lang.classloader.test3.TestA", "E:\\GitProject\\TestProject\\xue-gao-write-and-use\\use-jdk\\target\\classes\\javatest\\lang\\classloader\\test3\\TestA.class");
        classPathMap.put("javatest.lang.classloader.test3.TestB", "E:\\GitProject\\TestProject\\xue-gao-write-and-use\\use-jdk\\target\\classes\\javatest\\lang\\classloader\\test3\\TestB.class");
    }

    // 重写了 findClass 方法
    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
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