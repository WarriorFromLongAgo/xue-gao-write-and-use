package core.lang;

import cn.hutool.core.lang.Assert;

public class AssertTest {
    public static void main(String[] args) {
        // long lastTime = System.currentTimeMillis() + 1L;
        long lastTime = System.currentTimeMillis() - 1L;
        // long lastTime = System.currentTimeMillis();
        long nowTime = System.currentTimeMillis();
        Assert.isTrue(lastTime <= nowTime, "Clock is moving backwards, last time is {} milliseconds, current time is {} milliseconds", lastTime, nowTime);
        if (lastTime > nowTime) {
            System.out.println(String.format("Clock is moving backwards, last time is {} milliseconds, current time is {} milliseconds", lastTime, nowTime));
        }

        if (lastTime == nowTime) {
            System.out.println("======================");
        }


    }

}
