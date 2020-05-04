package com.jxkj.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述：Semaphore
 * <p>
 * 信号量主要用于两个目的：一个是多个共享资源的互斥使用，另一个用于并发线程数的控制。
 * 比如：控制流量，很多线程访问时，只需限制一下就行，修改一下Semaphore的初始值
 *
 * @author wcx
 * @version 1.0
 */
public class SemaphoreDemo11 {
    public static void main(String[] args) throws InterruptedException {
        // 模拟资源类，有3个空车位
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i < 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + "\t抢占到了车位");
                    try {
                        TimeUnit.SECONDS.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "\t离开了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
