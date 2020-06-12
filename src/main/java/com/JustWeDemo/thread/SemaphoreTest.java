package com.JustWeDemo.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 如何控制某个方法允许并发访问线程的个数？
 * 下面是一个测试，test()方法控制了线程一次只能有5个线程并发访问，
 * 当线程达到5个时候就需要排队，有线程释放的时候才会有下一个进入方法继续执行
 *
 */
public class SemaphoreTest {

    static Semaphore semaphore = new Semaphore(5, true);

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 100; i++) {
                new Thread(() -> test()).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void test() {

        try {
            semaphore.acquire();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "\t 进来了");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "\t 走了");

        semaphore.release();
    }
}
