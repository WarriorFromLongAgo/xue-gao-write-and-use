package javatest.lang.classloader.test2;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class ClassLoaderTest extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = getClassFile(name);
        try {
            byte[] bytes = getClassBytes(file);
            return defineClass(name, bytes, 0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    private File getClassFile(String name) {
        // return new File(name);
        // return new File("C:\\Users\\XianSky\\Desktop\\clazz\\ClassTest.class");
        return new File("E:\\GitProject\\TestProject\\xue-gao-write-and-use\\use-jdk\\target\\classes\\javatest\\lang\\classloader\\test2\\ClassLoaderTest.class");
    }

    private static byte[] getClassBytes(File file) throws Exception {
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream aos = new ByteArrayOutputStream(fis.available());
        byte[] bytes = new byte[fis.available()];  //使用fis.avaliable()方法确保整个字节数组没有多余数据
        fis.read(bytes);
        aos.write(bytes);
        fis.close();
        return aos.toByteArray();
    }

    public static void main(String[] args) throws Exception {
        ClassLoaderTest ct = new ClassLoaderTest();
        Class c = Class.forName("clazz.ClassTest", true, ct);
        System.out.println(c.getClassLoader());
    }
}
