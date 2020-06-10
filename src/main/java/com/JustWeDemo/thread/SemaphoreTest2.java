package com.JustWeDemo.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 问题：三个线程 a、b、c 并发运行，b,c 需要 a 线程的数据怎么实现?
 *
 * 思路：
 * 考虑到线程执行顺序的不确定性，线程a不一定在线程bc前执行，这里就需要想办法让a先执行
 * 用Semaphore. 定义一个信号量，该类内部维持了多个线程锁，可以阻塞多个线程，释放多个线程，
 * 线程的阻塞和释放是通过 permit 概念来实现的
 * 线程通过semaphore.acquire();方法获取permit，如果当前semaphore有permit则分配一个线程
 * 如果没有则阻塞，知道semaphore释放
 * 调用release()方法释放permit();
 * 构造函数中new Semaphore(个数);指的是允许的线程个数
 *
 */
public class SemaphoreTest2 {
    //定义一个变量作为数据
    public static int num;
    static Semaphore semaphore = new Semaphore(0);

    public static void main(String[] args) {

        Thread threadA = new Thread(() -> {
            try {
                //模拟耗时操作之后初始化变量 num
                TimeUnit.SECONDS.sleep(2);
                num = 666;
                //允许两个线程，释放两个permit
                semaphore.release(2);
            } catch (Exception e) {
            }
        });
        Thread threadB = new Thread(() -> {
            try {
                //获取permit，如果没有可用的permit，则等待，有就消耗一个
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName()+" num:"+num);
            } catch (Exception e) {
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                //获取permit，如果没有可用的permit，则等待，有就消耗一个
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName()+" num:"+num);
            } catch (Exception e) {
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
