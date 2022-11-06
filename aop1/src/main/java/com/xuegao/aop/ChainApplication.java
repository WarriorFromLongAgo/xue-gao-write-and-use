package com.xuegao.aop;

/**
 * @Author wmf
 * @Date 2022/1/18 15:45
 * @Description
 */
public class ChainApplication {
    public static void main(String[] args) {
        IceCreamMachine machine = new IceCreamMachine1();
        String iceCream = machine.cup("草莓", "大");
        System.out.println(iceCream);
        // 开始生产杯装冰淇淋
        // 草莓 杯装冰淇淋(大)

    }
}