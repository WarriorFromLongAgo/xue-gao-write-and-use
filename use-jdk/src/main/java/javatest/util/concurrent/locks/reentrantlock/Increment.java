package javatest.util.concurrent.locks.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Increment {

    private volatile int count = 0;

    private Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock();
        try {
            TimeUnit.SECONDS.sleep(5);
            count++;
            System.out.println(count);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Increment increment = new Increment();

        for (int i = 0; i < 100; i++) {
            new Thread(increment::increment).start();
        }

    }
}
