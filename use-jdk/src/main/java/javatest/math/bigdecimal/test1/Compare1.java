package javatest.math.bigdecimal.test1;

import java.math.BigDecimal;

public class Compare1 {
    public static void main(String[] args) {
        BigDecimal bigDecimal1 = BigDecimal.valueOf(1.0d);
        BigDecimal bigDecimal2 = BigDecimal.valueOf(1d);
        System.out.println("1 = " + bigDecimal1.equals(bigDecimal2));

        BigDecimal bigDecimal10 = new BigDecimal("1.0");
        BigDecimal bigDecimal20 = new BigDecimal("1.000");
        System.out.println("2 = " + bigDecimal10.equals(bigDecimal20));

        // 1 = true
        // 2 = false
    }
}
