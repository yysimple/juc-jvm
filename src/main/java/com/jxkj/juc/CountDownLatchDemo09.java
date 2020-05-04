package com.jxkj.juc;

import java.util.concurrent.CountDownLatch;

/**
 * 功能描述：CountDownLatch
 * 完成一个需求：指定的线程个数先执行，然后再执行其他的线程
 *  可以自定义先执行的线程数
 *
 * @author wcx
 * @version 1.0
 */
public class CountDownLatchDemo09 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t离开教室");
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t关门走人");
    }

    private static void closeDoor() {
        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t离开教室");
            }, String.valueOf(i)).start();
        }
    }
}
