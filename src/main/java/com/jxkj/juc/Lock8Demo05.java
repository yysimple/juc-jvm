package com.jxkj.juc;

import java.util.concurrent.TimeUnit;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
public class Lock8Demo05 {
    public static void main(String[] args) throws InterruptedException {
        Phone phone = new Phone();
        Phone phone2 = new Phone();

        new Thread(() -> {
            try {
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "A").start();

            Thread.sleep(1000);

        new Thread(() -> {
            try {
                phone2.sendMessage();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "B").start();

        new Thread(() -> {
            try {
                phone2.sayHello();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "B").start();
    }
}

/**
 * 一个类里面，如果有多个同步方法（synchronized），某一时刻只能访问唯一的一个同步方法
 * 其他的线程只能去等待，其锁的是当前对象this，被锁定后其他线程都不能进入到当前对象去访问其他的synchronized
 *
 * 如果同步之上再加上 static 就是属于类了 在使用不同对象去调用 synchronized方法的时候，还是需要等待
 */
class Phone {
    public synchronized void sendEmail() throws Exception {
        //TimeUnit.SECONDS.sleep(4);
        System.out.println("Send Email ... ");
    }

    public synchronized void sendMessage() throws Exception {
        System.out.println("Send Message ... ");
    }

    public void sayHello() {
        System.out.println("Say Hello ... ");
    }
}

