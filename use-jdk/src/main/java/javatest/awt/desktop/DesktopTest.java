package javatest.awt.desktop;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class DesktopTest {
    public static void main(String[] args) throws IOException {
        // 获取 Desktop 实例
        Desktop desktop = Desktop.getDesktop();

        // 打开文本文件
        desktop.open(new File("example.txt"));
    }
}
