package com.jxkj.juc;

import java.util.concurrent.*;

/**
 * 功能描述：线程池
 * 线程满了之后的策略：
 *  AbortPolicy：直接抛出RejectedExecutionException异常，组织系统正常运行
 *  CallerRunsPolicy: "调用者运行"一种调节机制，该策略既不会抛弃任务，也不会抛出异常，而是将某些任务回退到调用者，从而降低新任务的流量
 *  DiscardOldestPolicy: 抛弃队列中等待最久的任务，然后把当前任务加入队列中尝试在次提交当前任务
 *  DiscardPolicy: 默默丢弃无法处理的任务，不予任何处理，也不抛出异常。如果允许任务丢失，这就是最好的策略
 *
 * @author wcx
 * @version 1.0
 */
public class MyThreadPoolDemo14 {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService threadPool = new ThreadPoolExecutor(2,
                5,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());
        try {
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
        // initThreadPool();
    }

    private static void initThreadPool() {
        // 一个线程池,5个工作线程
        // ExecutorService threadPool = Executors.newFixedThreadPool(5);

        // 一个线程池,1个工作线程
        // ExecutorService threadPool = Executors.newSingleThreadExecutor();

        // 时间调度，可做定时
        // ExecutorService threadPool = Executors.newScheduledThreadPool(5);

        // ExecutorService threadPool = Executors.newWorkStealingPool();

        // 一个线程池, N个工作线程
        ExecutorService threadPool = Executors.newCachedThreadPool();

        try {
            for (int i = 1; i <= 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
