package com.jxkj.juc;

/**
 * 功能描述：生产者，消费者模式 线程
 * <p>
 * 线程：
 * 1. 高内聚低耦合下，线程操作资源类
 * 2. 判断/生产/通知
 * 3. 防止虚假唤醒（不能使用if作为判断，应该用 while）
 *
 * @author wcx
 * @version 1.0
 */
public class ProdConsumerDemo04 {
    public static void main(String[] args) {
        AirCondition airCondition = new AirCondition();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    airCondition.product();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    airCondition.consumer();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    airCondition.product();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    airCondition.consumer();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }
}

class AirCondition {
    private int number = 0;

    public synchronized void product() throws Exception {
        // 1. 判断
        while (number != 0) {
            this.wait();
        }
        // 2. 生产
        number++;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        // 3. 通知
        this.notifyAll();
    }

    public synchronized void consumer() throws Exception {
        while (number == 0) {
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "\t" + number);
        this.notifyAll();
    }
}
