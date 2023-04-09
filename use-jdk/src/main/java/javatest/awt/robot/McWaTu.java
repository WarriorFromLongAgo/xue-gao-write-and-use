package javatest.awt.robot;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class McWaTu {
    public static void main(String[] args) throws AWTException, InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        System.out.println("请进入MC游戏窗口");
        // 创建 Robot 实例
        Robot robot = new Robot();

        for (int i = 0; i < 10000; i++) {
            // 移动鼠标到指定位置
            // robot.mouseMove(964, 542);
            // 按下鼠标左键w
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            TimeUnit.SECONDS.sleep(2);
            // 释放鼠标左键w
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

            // 按下 W 键WW
            robot.keyPress(KeyEvent.VK_W);
            TimeUnit.MILLISECONDS.sleep(500);
            // 释放 W 键w
            robot.keyRelease(KeyEvent.VK_W);
        }
    }
}
