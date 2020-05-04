package com.jxkj.jvm;

/**
 * 功能描述：
 * java8之后，元空间并不在虚拟机中而是使用本机物理内存
 * -Xms：设置初始分配大小，默认为物理内存的1/64
 * -Xmx：最大分配内存，默认为物理内存 1/4
 * -XX:+PrintDCDetails：输出详细的GC处理日志
 *
 * 理论上应该将初始内存和最大内存调为相同值，避免内存忽高忽低产生停顿
 *
 * @author wcx
 * @version 1.0
 */
public class HeapFixDemo0601 {
    public static void main(String[] args) {
        // 返回Java虚拟机试图使用的最大内存
        long maxMemory = Runtime.getRuntime().maxMemory();
        // JVM中剩余的内存
        long masMemory = Runtime.getRuntime().freeMemory();
        // 返回Java中内存使用的总量
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println("MAX_MEMORY:" + maxMemory + "(bit)  " + (double)maxMemory/1024/1024 + "MB");
        System.out.println("MAX_MEMORY:" + masMemory + "(bit)  " + (double)masMemory/1024/1024 + "MB");
        System.out.println("TOTAL_MEMORY:" + totalMemory + "(bit)  " + (double)totalMemory/1024/1024 + "MB");

    }
}
