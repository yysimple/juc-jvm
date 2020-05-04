package com.jxkj.juc;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
public class CreateThread4Way {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //1. 继承线程类
        new ExtendsThread().start();
        //2. 实现Runnable接口
        new Thread(new ImplRunnable(), "A").start();
        //3. 实现Callable接口
        FutureTask futureTask = new FutureTask(new ImplCallable());
        new Thread(futureTask, "B").start();
        System.out.println(futureTask.get());
        //4. 通过线程池创创建
        MyThreadPool myThreadPool = new MyThreadPool();
        myThreadPool.getThread();

    }
}

class ExtendsThread extends Thread {

}

class ImplRunnable implements Runnable {

    @Override
    public void run() {

    }
}

class ImplCallable implements Callable {

    @Override
    public Object call() throws Exception {
        return "我是实现Callable的线程";
    }
}

class MyThreadPool {


    /**
     * 定义静态内部线程类
     */
    public class MyTestThread implements Runnable {

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + "name:"
                    + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void getThread() {
        MyTestThread myTestThread = new MyTestThread();
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("thread-pool-%d").build();
        ExecutorService executorService = new ThreadPoolExecutor(5, 10,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 15; i++) {
            executorService.execute(myTestThread);
        }
        executorService.shutdown();
    }

}




