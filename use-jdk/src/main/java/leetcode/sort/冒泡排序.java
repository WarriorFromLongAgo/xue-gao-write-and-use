package leetcode.sort;

import leetcode.LeetCodeConstant;

import java.util.Arrays;
import java.util.Objects;

public class 冒泡排序 {
    public static void main(String[] args) {
        double[] sort = sort(LeetCodeConstant.DOUBLE_ARR);
        System.out.println("end = " + Arrays.toString(sort));
    }

    public static double[] sort(double[] inputArr) {
        // 最外层遍历
        // 在i+1的地方，进行内层的遍历，如果i比i+1大，那么交换位置，小的保持在前面
        if (Objects.isNull(inputArr) || inputArr.length <= 1) {
            return inputArr;
        }
        for (int i = 0; i < inputArr.length; i++) {
            for (int j = i + 1; j < inputArr.length; j++) {
                double tempI = inputArr[i];
                double tempJ = inputArr[j];
                if (tempI > tempJ) {
                    inputArr[j] = tempI;
                    inputArr[i] = tempJ;
                }
            }
        }
        return inputArr;
    }

    public static double[] sortV2(double[] inputArr) {
        // 最外层遍历
        // 在i+1的地方，进行内层的遍历，如果i比i+1大，那么交换位置，小的保持在前面
        if (Objects.isNull(inputArr) || inputArr.length <= 1) {
            return inputArr;
        }
        for (int i = 0; i < inputArr.length - 1; i++) {
            for (int j = i + 1; j < inputArr.length - i - 1; j++) {
                double tempI = inputArr[i];
                double tempJ = inputArr[j];
                if (tempI > tempJ) {
                    inputArr[j] = tempI;
                    inputArr[i] = tempJ;
                }
            }
        }
        return inputArr;
    }

}
