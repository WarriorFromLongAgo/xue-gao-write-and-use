package leetcode.sort;

public class 每次一半 {
    public static void main(String[] args) {
        double sum = 0;
        double height = 100;
        for (int i = 1; i <= 10; i++) {
            double tempHeight = height / 2;
            sum = sum + height + tempHeight;
            System.out.println("i次数 = " + i + ", height = " + height);
            System.out.println("sum = " + sum);

            height = height / 2;
        }
        System.out.println("共经过" + sum + "米");
    }
}
