package common.model;

import java.sql.Statement;

public class Test {
    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'g';
    }

    public static void main(String args[]) {
        String x = "string";
        String y = "string";
        String z = new String("string");
        System.out.println(x==y);
        System.out.println(x==z);
        System.out.println(x.equals(y));
        System.out.println(x.equals(z));

    }
}