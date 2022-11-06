package com.xuegao.aop;

/**
 * @Author wmf
 * @Date 2022/1/18 15:37
 * @Description 模拟一个冰淇淋机
 */
public class IceCreamMachine1 implements IceCreamMachine {
    /**
     * 模拟生产杯装冰淇淋
     *
     * @param taste 草莓/原味/巧克力
     * @param size  大/中/小
     * @return 冰淇淋
     */
    @Override
    public String cup(String taste, String size) {
        System.out.println("开始生产杯装冰淇淋");
        return taste + " 杯装冰淇淋(" + size + ")";
    }

    /**
     * 模拟生产蛋筒冰淇淋
     *
     * @param taste 草莓/原味/巧克力
     * @param size  大/中/小
     * @return 冰淇淋
     */
    @Override
    public String eggCone(String taste, String size) {
        System.out.println("开始生产蛋筒冰淇淋");
        return taste + " 蛋筒冰淇淋(" + size + ")";
    }
}