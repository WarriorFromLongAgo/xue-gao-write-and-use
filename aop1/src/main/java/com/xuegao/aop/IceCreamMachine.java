package com.xuegao.aop;

public interface IceCreamMachine {
	/**
	 * 模拟生产杯装冰淇淋
	 * @param taste 草莓/原味/巧克力
	 * @param size 大/中/小
	 * @return 冰淇淋
	 */
	String cup(String taste, String size);
	/**
	 * 模拟生产蛋筒冰淇淋
	 * @param taste 草莓/原味/巧克力
	 * @param size 大/中/小
	 * @return 冰淇淋
	 */
	String eggCone(String taste, String size);
}