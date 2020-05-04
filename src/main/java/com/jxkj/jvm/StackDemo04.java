package com.jxkj.jvm;

/**
 * 功能描述：栈
 * <p>
 * 栈管运行，堆管存储
 *
 * 栈也叫内存，主管java程序的运行吗，是在线程创建的时候创建，与线程的生命周期是一致的
 * 是线程私有的，对栈来说没有垃圾回收问题
 * 8种基本类型的变量+对象的引用变量+实例方法都是在函数的栈内存中分配。
 *
 * java方法 = 栈帧
 *
 * Exception in thread "main" java.lang.StackOverflowError SOF 栈溢出 这是一个错误
 *
 * @author wcx
 * @version 1.0
 */
public class StackDemo04 {
    public static void main(String[] args) {
        System.out.println("111111111");
        m1();
        System.out.println("444444444");
    }

    public static void m1() {
        System.out.println("222222222");
        m1();
        System.out.println("333333333");
    }
}
