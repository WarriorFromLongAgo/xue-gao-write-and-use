package javatest.lang.string;

public class SubStringTest {
    public static void main(String[] args) {
        String str = "SN-ABB001-SK";
        String substring = str.substring(0, str.lastIndexOf("-"));
        System.out.println(substring);
    }
}
