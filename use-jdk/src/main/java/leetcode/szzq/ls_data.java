package leetcode.szzq;

import java.io.File;
import java.util.Objects;

public class ls_data {
    public static void main(String[] args) {
        String path = "C://";
        getFile(path);
    }

    private static void getFile(String path) {
        File file = new File(path);
        File[] array = file.listFiles();
        if (Objects.isNull(array)) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i].isFile()) {
                // only take file name
                System.out.println("fileName = " + array[i].getName());
                // take file path and name
                System.out.println("filePath = " + array[i]);
                // take file path and name
                System.out.println("filePath = " + array[i].getPath());
            } else if (array[i].isDirectory()) {
                getFile(array[i].getPath());
            }
        }
    }
}
