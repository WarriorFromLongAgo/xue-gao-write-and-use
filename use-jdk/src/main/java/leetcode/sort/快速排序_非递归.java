package leetcode.sort;

import leetcode.LeetCodeConstant;

import java.util.Arrays;
import java.util.Stack;

public class 快速排序_非递归 {
    public static void main(String[] args) {
        quickSortByLoop(LeetCodeConstant.INT_ARR);
        System.out.println("end = " + Arrays.toString(LeetCodeConstant.INT_ARR));
    }

    public static void quickSortByLoop(int[] array) {
        Stack<Integer> stack = new Stack<>();
        stack.push(array.length - 1);
        stack.push(0);

        while (!stack.isEmpty()) {
            int left = stack.pop();
            int right = stack.pop();

            if (left >= right) {
                continue;
            }

            int index = partition(array, left, right);
            stack.push(right);
            stack.push(index + 1);

            stack.push(index - 1);
            stack.push(left);
        }
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

            //代码走到这里,i有可能和j重合,也有可能是找到了比基准值大的元素
            //下面,循环从由向左找比基准值小的元素
            while (i < j && array[j] >= base) {
                j--;
            }

            //交换i位置的元素和j位置的元素
            swap(array, i, j);
        }
        //代码跳出循环之后,说明i和j重合了,就需要交换重合位置的元素和基准值。
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
// ————————————————
//     版权声明：本文为CSDN博主「明明脑子不够用了」的原创文章,遵循CC 4.0 BY-SA版权协议,转载请附上原文出处链接及本声明。
//     原文链接：https://blog.csdn.net/bygc98/article/details/121197045

}
