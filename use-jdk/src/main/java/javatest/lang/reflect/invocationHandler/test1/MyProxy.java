package javatest.lang.reflect.invocationHandler.test1;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MyProxy {

    // 回车、换行符
    public static final String ln = "\r\n";

    /**
     * 重新生成一个新的类,并实现被代理类实现的所有接口
     *
     * @param classLoader       类加载器
     * @param interfaces        被代理类实现的所有接口
     * @param invocationHandler
     * @return 返回字节码重组以后的新的代理对象
     */
    public static Object newProxyInstance(MyClassLoader classLoader, Class<?>[] interfaces, MyInvocationHandler invocationHandler) {
        try {
            // 动态生成源代码.java文件
            String sourceCode = generateSourceCode(interfaces);

            // 将源代码写入到磁盘中
            String filePath = MyProxy.class.getResource("").getPath();
            File f = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(f);
            fw.write(sourceCode);
            fw.flush();
            fw.close();

            // 把生成的.java文件编译成.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manage = compiler.getStandardFileManager(null, null, null);
            Iterable iterable = manage.getJavaFileObjects(f);
            JavaCompiler.CompilationTask task = compiler.getTask(null, manage, null, null, null, iterable);
            task.call();
            manage.close();

            // 编译生成的.class文件加载到JVM中来
            Class proxyClass = classLoader.findClass("$Proxy0");
            Constructor c = proxyClass.getConstructor(MyInvocationHandler.class);

            //删除生成的.java文件
            f.delete();

            // 返回字节码重组以后的新的代理对象
            return c.newInstance(invocationHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 动态生成源代码.java文件
     *
     * @param interfaces 被代理类实现的所有接口
     * @return .java文件的源代码
     */
    private static String generateSourceCode(Class<?>[] interfaces) {
        StringBuffer sb = new StringBuffer();
        sb.append(MyProxy.class.getPackage() + ";" + ln);
        sb.append("import " + interfaces[0].getName() + ";" + ln);
        sb.append("import java.lang.reflect.*;" + ln);
        sb.append("public class $Proxy0 implements " + interfaces[0].getName() + "{" + ln);
        sb.append("MyInvocationHandler invocationHandler;" + ln);
        sb.append("public $Proxy0(MyInvocationHandler invocationHandler) { " + ln);
        sb.append("this.invocationHandler = invocationHandler;");
        sb.append("}" + ln);
        for (Method m : interfaces[0].getMethods()) {
            Class<?>[] params = m.getParameterTypes();

            StringBuffer paramNames = new StringBuffer();
            StringBuffer paramValues = new StringBuffer();
            StringBuffer paramClasses = new StringBuffer();

            for (int i = 0; i < params.length; i++) {
                Class clazz = params[i];
                String type = clazz.getName();
                String paramName = toLowerFirstCase(clazz.getSimpleName());
                paramNames.append(type + " " + paramName);
                paramValues.append(paramName);
                paramClasses.append(clazz.getName() + ".class");
                if (i > 0 && i < params.length - 1) {
                    paramNames.append(",");
                    paramClasses.append(",");
                    paramValues.append(",");
                }
            }

            sb.append("public " + m.getReturnType().getName() + " " + m.getName() + "(" + paramNames + ") {" + ln);
            sb.append("try{" + ln);
            sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() + "\",new Class[]{" + paramClasses + "});" + ln);
            sb.append((hasReturnValue(m.getReturnType()) ? "return " : "") + getCaseCode("this.invocationHandler.invoke(this,m,new Object[]{" + paramClasses + "})", m.getReturnType()) + ";" + ln);
            sb.append("}catch(Error ex) { }");
            sb.append("catch(Throwable e){" + ln);
            sb.append("throw new UndeclaredThrowableException(e);" + ln);
            sb.append("}");
            sb.append(getReturnEmptyCode(m.getReturnType()));
            sb.append("}");
        }
        sb.append("}" + ln);
        return sb.toString();
    }

    /**
     * 定义返回类型
     */
    private static Map<Class, Class> mappings = new HashMap<Class, Class>();

    /**
     * 初始化一些返回类型
     */
    static {
        mappings.put(int.class, Integer.class);
        mappings.put(Integer.class, Integer.class);
        mappings.put(double.class, Double.class);
        mappings.put(Double.class, Double.class);
    }

    private static String getReturnEmptyCode(Class<?> returnClass) {
        if (mappings.containsKey(returnClass)) {
            if (returnClass.equals(int.class) || returnClass.equals(Integer.class)) {
                return "return 0;";
            } else if (returnClass.equals(double.class) || returnClass.equals(Double.class)) {
                return "return 0.0;";
            } else {
                return "return 0;";
            }
        } else if (returnClass == void.class) {
            return "";
        } else {
            return "return null;";
        }
    }

    /**
     * 判断返回值类型
     *
     * @param code
     * @param returnClass
     * @return
     */
    private static String getCaseCode(String code, Class<?> returnClass) {
        if (mappings.containsKey(returnClass)) {
            // ((java.lang.Double) this.invocationHandler.invoke(this, m, new Object[]{})).doubleValue();
            String re = "((" + mappings.get(returnClass).getName() + ")" + code + ")." + returnClass.getSimpleName().toLowerCase() + "Value()";
            return re;
        }
        return code;
    }

    /**
     * 判断代理接口的方法的返回值是否为void
     *
     * @param clazz 方法的返回值类型
     * @return
     */
    private static boolean hasReturnValue(Class<?> clazz) {
        return clazz != void.class;
    }

    /**
     * 参数首字母小写
     *
     * @param src
     * @return
     */
    private static String toLowerFirstCase(String src) {
        char[] chars = src.toCharArray();
        if (chars[0] >= 'A' && chars[0] <= 'Z') {
            chars[0] += 32;
        }
        return String.valueOf(chars);
    }

    /**
     * 首字母大写
     *
     * @param src
     * @return
     */
    private static String toUpperFirstCase(String src) {
        char[] chars = src.toCharArray();
        if (chars[0] >= 'a' && chars[0] <= 'z') {
            chars[0] -= 32;
        }
        return String.valueOf(chars);
    }
}