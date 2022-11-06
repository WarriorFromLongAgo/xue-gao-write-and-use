package com.xuegao.aop2;

import com.xuegao.aop.IceCreamMachine;

/**
 * @Author wmf
 * @Date 2022/1/18 15:58
 * @Description 机器的代理
 */
public class IceCreamMachineProxy implements IceCreamMachine {
    public IceCreamMachineProxy(IceCreamMachine iceCreamMachine) {
        this.iceCreamMachine = iceCreamMachine;
    }

    private IceCreamMachine iceCreamMachine;

    @Override
    public String cup(String taste, String size) {
        System.out.println("模拟记录需求" + taste + size);
        return iceCreamMachine.cup(taste, size);
    }

    @Override
    public String eggCone(String taste, String size) {
        System.out.println("模拟记录需求" + taste + size);
        return iceCreamMachine.eggCone(taste, size);
    }
}