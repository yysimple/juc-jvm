package com.jxkj.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 功能描述：
 * 实现Callable， 然后通过 中间类FutureTask构造器初始化线程，在通过new Thread() 创建线程
 *
 * @author wcx
 * @version 1.0
 */
public class CallableDemo08 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //1. 将继承了Callable的类的传入FutureTask构造器
        FutureTask<Integer> futureTask = new FutureTask(new MyThread());
        //2. FutureTask implements RunnableFuture<V> extends Runnable, Future<V>，这样就可以传入FutureTask，就可以完成线程的创建
        new Thread(futureTask, "A").start();
        //3. 获取该线程返回的值
        Integer result = futureTask.get();
        System.out.println(result);

    }
}

/**
 * 有返回值的线程创建
 */
class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("i am Callable call...");
        return 1024;
    }
}
