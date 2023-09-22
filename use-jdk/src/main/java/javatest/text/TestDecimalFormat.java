package javatest.text;

import org.apache.commons.lang3.StringUtils;

import java.text.DecimalFormat;

public class TestDecimalFormat {
    public static void main(String[] args) {
       left();

    }

    private static void extracted() {
        DecimalFormat df = new DecimalFormat("0000000");
        String format = df.format(1);
        System.out.println(format);
    }

    public static void left(){
        String s = StringUtils.leftPad("xxxx", 10, "X");
        System.out.println(s);
    }
}
