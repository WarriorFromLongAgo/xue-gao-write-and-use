package com.xuegao.aop2;

import com.xuegao.aop.IceCreamMachine;
import com.xuegao.aop.IceCreamMachine1;

public class ChainApplication {
    public static void main(String[] args) {
        IceCreamMachine machine = new IceCreamMachine1();
        IceCreamMachine machineProxy = new IceCreamMachineProxy(machine);
        String iceCream = machineProxy.cup("草莓", "大");
        System.out.println(iceCream);
        // 模拟记录需求草莓大
        // 开始生产杯装冰淇淋
        // 草莓 杯装冰淇淋(大)

    }
}