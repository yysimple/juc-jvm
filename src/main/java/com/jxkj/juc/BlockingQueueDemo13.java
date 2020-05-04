package com.jxkj.juc;

import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述：阻塞队列
 * 在多线程领域，所谓阻塞，在某些情况下会挂其线程（即阻塞），一旦满足条件，被挂起的线程又会被唤醒
 * 使用BlockingQueue我们就不需要去关心什么时候需要去阻塞线程，什么时候去唤醒线程，因为这一切都被BlockingQueue包办了
 *
 * @author wcx
 * @version 1.0
 */
public class BlockingQueueDemo13 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        /**
         * add / remove: 会抛出异常
         */
        /*// 添加的返回时true
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
        // 超过容量3 会报错 Queue full
        // System.out.println(blockingQueue.add("c"));

        // 删除的时候，没有指定元素则会报错 java.util.NoSuchElementException
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());*/

        /**
         *  offer / poll 不会抛出异常
         */
        /*System.out.println(blockingQueue.offer("a"));
        System.out.println(blockingQueue.offer("b"));
        System.out.println(blockingQueue.offer("c"));
        // 这个是会返回false
        // System.out.println(blockingQueue.offer("c"));

        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        // 这个如果没有元素可以移除了，会返回null值
        System.out.println(blockingQueue.poll());*/

        /**
         * put / take： 两者就会一直阻塞
         */
        blockingQueue.put("a");
        blockingQueue.put("a");
        blockingQueue.put("a");
        // blockingQueue.put("a");

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        // System.out.println(blockingQueue.take());

        System.out.println(blockingQueue.offer("a", 3L, TimeUnit.SECONDS));
    }
}
