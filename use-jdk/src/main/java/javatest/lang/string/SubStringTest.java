package javatest.lang.string;

public class SubStringTest {
    public static void main(String[] args) {
        String str = "SN-ABB001-SK";
        String substring = str.substring(0, str.lastIndexOf("-"));
        System.out.println(substring);

        String str2 = "24.6666";
        String[] split = str2.split("\\.");
        String substring1 = split[1].substring(0, 2);
        System.out.println(substring1);

    }
}
