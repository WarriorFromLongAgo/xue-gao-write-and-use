package com.xuegao.agent;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class MyTransformer implements ClassFileTransformer {

    /**
     *
     */
    private String packageName;

    public MyTransformer(String packageName) {
        System.out.println("load success from agent1");
        this.packageName = packageName;
    }

    @Override
    public byte[] transform(ClassLoader loader,
                            String className,
                            Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain,
                            byte[] classfileBuffer) throws IllegalClassFormatException {
        className = className.replace("/", ".");
        System.out.println("=========================" + className);
        if (!className.contains(packageName)) {
            return classfileBuffer;
        }
        return classfileBuffer;
    }
}
