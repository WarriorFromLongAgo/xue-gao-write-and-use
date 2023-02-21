package javatest.util.arr;

import common.model.temp.TempListBO;

import java.util.Arrays;
import java.util.List;

public class Copy {
    public static void main(String[] args) {
        int[] intArr1 = new int[]{1, 2, 3, 4, 5};
        System.out.println("intArr1 " + Arrays.toString(intArr1));
        int[] intArr2 = intArr1.clone();
        System.out.println("intArr2 " + Arrays.toString(intArr2));
        intArr2[0] = 11111;
        System.out.println("intArr1 " + Arrays.toString(intArr1));
        System.out.println("intArr2 " + Arrays.toString(intArr2));

        TempListBO[] tempListBOArr1 = new TempListBO[3];
        List<TempListBO> list = TempListBO.getList();
        for (int i = 0; i < list.size(); i++) {
            tempListBOArr1[0] = list.get(i);
        }


    }
}
