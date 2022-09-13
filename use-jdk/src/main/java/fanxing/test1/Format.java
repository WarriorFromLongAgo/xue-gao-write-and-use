package fanxing.test1;

import java.math.BigDecimal;

public class Format<T> {

    public static void main(String[] args) {
        Integer format = Format.format(0, 1, Integer.MAX_VALUE);
        System.out.println(format);

        BigDecimal format2 = Format.format(BigDecimal.ZERO, BigDecimal.ONE, BigDecimal.TEN);
        System.out.println(format2);
    }

    public static <T extends Comparable<T>> T format(T input, T min, T max) {
        if (input == null) {
            input = min;
        } else if (input.compareTo(min) <= 0) {
            input = min;
        } else if (input.compareTo(max) >= 0) {
            input = max;
        }
        return input;
    }


    static BigDecimal format(BigDecimal input, BigDecimal min, BigDecimal max) {
        if (input == null) {
            input = min;
        } else if (input.compareTo(min) <= 0) {
            input = min;
        } else if (input.compareTo(max) >= 0) {
            input = max;
        }
        return input;
    }

    static Integer format(Integer input, Integer min, Integer max) {
        if (input == null) {
            input = min;
        } else if (input.compareTo(min) <= 0) {
            input = min;
        } else if (input.compareTo(max) >= 0) {
            input = max;
        }
        return input;
    }
}
