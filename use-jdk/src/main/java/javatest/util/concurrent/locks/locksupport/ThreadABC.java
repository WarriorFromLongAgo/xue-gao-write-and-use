package javatest.util.concurrent.locks.locksupport;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * 三个线程打印ABC
 */
public class ThreadABC {

    private void printA(Thread thread) {
        try {
            TimeUnit.SECONDS.sleep(20);
            System.out.print("-A-");
            LockSupport.unpark(thread);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void printB(Thread thread) {
        try {
            TimeUnit.SECONDS.sleep(10);
            LockSupport.park(thread);
            System.out.print("-B-");
            LockSupport.unpark(thread);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void printC() {
        try {
            TimeUnit.SECONDS.sleep(5);
            LockSupport.park();
            System.out.print("-C-");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThreadABC threadABC = new ThreadABC();
        Thread threadC = new Thread(threadABC::printC);
        Thread threadB = new Thread(() -> threadABC.printB(threadC));
        Thread threadA = new Thread(() -> threadABC.printA(threadB));

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
