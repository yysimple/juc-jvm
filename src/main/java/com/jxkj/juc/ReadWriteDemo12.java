package com.jxkj.juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 功能描述：读写锁
 *
 * 读操作能共存，写操作不能共存
 *
 * @author wcx
 * @version 1.0
 */
public class ReadWriteDemo12 {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        // 写入数据
        for (int i = 0; i < 3; i++) {
            final int finalI = i;
            new Thread(() -> {
                myCache.put(finalI + "", finalI + "");
            }, String.valueOf(finalI)).start();
        }
        // 读取数据
        for (int i = 0; i < 3; i++) {
            final int finalI = i;
            new Thread(() -> {
                myCache.get(finalI + "");
            }, String.valueOf(finalI)).start();
        }
    }
}

class MyCache{
    private volatile Map<String, Object> map = new HashMap<>(16);

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    public void put(String key, Object value){
        readWriteLock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName() + "\t写入数据" + key);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key, value);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();
        }
        System.out.println(Thread.currentThread().getName() + "\t写入完成");
    }

    public void get(String key){
        readWriteLock.readLock().lock();
        Object result= null;
        try {
            System.out.println(Thread.currentThread().getName() + "\t读取数据");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            result = map.get(key);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readWriteLock.readLock().unlock();
        }
        System.out.println(Thread.currentThread().getName() + "\t读取完成" + result);
    }
}
