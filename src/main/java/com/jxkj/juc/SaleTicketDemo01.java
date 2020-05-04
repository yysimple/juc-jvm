package com.jxkj.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 功能描述：售票
 *
 * @author wcx
 * @version 1.0
 */
public class SaleTicketDemo01 {
    public static void main(String[] args) {

        Ticket ticket = new Ticket();
        /**
         * 开始卖票，三个各自分配，跟cpu和操作系统有关，随机调度
         */
        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                ticket.sale();
            }
        }, "C").start();
    }
}

/**
 * 资源类
 */
class Ticket{
    private int number = 30;

    /**
     * ReentrantLock: 可重入锁
     */
    Lock lock = new ReentrantLock();

    public void sale() {
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(java.lang.Thread.currentThread().getName() +"\t 卖出第：" + (number--) + " \t 还剩下： " + number );
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
