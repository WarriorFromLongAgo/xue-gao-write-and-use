package javatest.lang.runtime;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class 获取所有的文件夹 {

    public static void main(String[] args) throws Exception {
        String[] cmd = {"ls", "/"};
        InputStream is = Runtime.getRuntime().exec(cmd).getInputStream();
        InputStreamReader isr = new InputStreamReader(is, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String line = br.readLine();
        while (line != null) {
            System.out.println(line);
            line = br.readLine();
        }
    }

}
