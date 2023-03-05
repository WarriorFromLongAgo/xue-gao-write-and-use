package leetcode.sort;

import leetcode.LeetCodeConstant;

import java.util.Arrays;

public class 快速排序_递归 {
    public static void main(String[] args) {
        quickSort(LeetCodeConstant.INT_ARR);
        System.out.println("end = " + Arrays.toString(LeetCodeConstant.INT_ARR));
    }

    public static void quickSort(int[] array) {
        quickSortHelper(array, 0, array.length - 1);//辅助方法
    }

    private static void quickSortHelper(int[] array, int left, int right) {
        if (left >= right) {
            //说明这个区间中有0个或者1个元素
            return;
        }

        int index = partition(array, left, right);//重合位置的下标
        quickSortHelper(array, left, index - 1);//递归实现左区间
        quickSortHelper(array, index + 1, right);//递归实现右区间
    }

    private static int partition(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int base = array[j];
        while (i < j) {
            //循环从左向后找到比基准值大的元素
            while (i < j && array[i] <= base) {
                i++;
            }

            //代码走到这里，i有可能和j重合，也有可能是找到了比基准值大的元素
            //下面，循环从由向左找比基准值小的元素
            while (i < j && array[j] >= base) {
                j--;
            }

            //交换i位置的元素和j位置的元素
            swap(array, i, j);
        }
        //代码跳出循环之后，说明i和j重合了，就需要交换重合位置的元素和基准值。
        swap(array, i, right);
        return i;
    }

    private static void swap(int[] inputArr, int i, int j) {
        // int tmp = array[j];
        // array[j] = array[i];
        // array[i] = tmp;

        int tempI = inputArr[i];
        int tempJ = inputArr[j];
        if (tempI > tempJ) {
            inputArr[j] = tempI;
            inputArr[i] = tempJ;
        }
    }
}
