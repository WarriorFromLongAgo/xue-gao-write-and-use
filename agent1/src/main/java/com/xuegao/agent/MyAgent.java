package com.xuegao.agent;

import java.lang.instrument.Instrumentation;

public class MyAgent {
    private static Instrumentation _inst;

    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("[MyAgent][premain][agentArgs=" + agentArgs);
        inst.addTransformer(new MyTransformer(agentArgs));
        _inst = inst;
    }

    public static void premain(String agentArgs) {

    }

    public static void agentmain(String agentArgs, Instrumentation inst) {
        System.out.println("agentmain = " + agentArgs);
    }

    public static long sizeOf(Object o) {
        return _inst.getObjectSize(o);
    }
}
