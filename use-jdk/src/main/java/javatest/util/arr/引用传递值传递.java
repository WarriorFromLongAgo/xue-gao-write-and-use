package javatest.util.arr;

import java.util.Arrays;

public class 引用传递值传递 {
    public static void main(String[] args) {
        int[] intArr1 = new int[]{1, 2, 3, 4, 5};
        int[] intArr2 = intArr1;
        System.out.println(Arrays.toString(intArr1));
        System.out.println(Arrays.toString(intArr2));
        System.out.println("================================");
        intArr1[0] = 100;
        System.out.println(Arrays.toString(intArr1));
        System.out.println(Arrays.toString(intArr2));
    }
}
