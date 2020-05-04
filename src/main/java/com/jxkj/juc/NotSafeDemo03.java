package com.jxkj.juc;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
public class NotSafeDemo03 {
    public static void main(String[] args) {
        listNotSafe();
    }

    private static void mapNotSafe() {
        Map<String, String> map = new ConcurrentHashMap<>(16);
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }

    private static void setNotSafe() {
        Set<String> strings = new CopyOnWriteArraySet<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                strings.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(strings);
            }, String.valueOf(i)).start();
        }
    }

    private static void listNotSafe() {
        /**
         * 会出现：java.util.ConcurrentModificationException这个并发异常
         *
         * 使用 Victor  可以解决，但是会影响效率
         * 可以使用集合工具类来解决线程安全
         *
         * CopyOnWriteArrayList<>(): 写实集合类
         */
        //1. List<String> list = new ArrayList<>();
        //2. List<String> list = Collections.synchronizedList(new ArrayList<>());

        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 1; i <= 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }
    }
}
