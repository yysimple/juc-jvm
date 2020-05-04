package com.jxkj.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
public class ProdConsumerLock06 {
    public static void main(String[] args) {
        AirCondition02 airCondition02 = new AirCondition02();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    airCondition02.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    airCondition02.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    airCondition02.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    airCondition02.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }
}

class AirCondition02 {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private int number = 0;

    public void increment() throws Exception {
        lock.lock();
        try {
            // 1. 判断
            while (number != 0) {
                condition.await();
            }
            // 2. 生产
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);

            // 3. 通知
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void decrement() throws Exception {
        lock.lock();
        try {
            // 1. 判断
            while (number == 0) {
                condition.await();
            }
            // 2. 生产
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);

            // 3. 通知
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
