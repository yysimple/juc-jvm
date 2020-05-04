package com.jxkj.jvm;

/**
 * 功能描述：Native
 * 只要是调用 native方法，代表的是跟java无关的，底层的第三方库或者c语言库的方法。
 *
 * native是一个关键字
 * 这个存在的原因是当时java太弱，想要发展就需要为 c/c++ 专门提供一个 本地方法栈 用来存放 native方法
 * native方法都没有实现，需要去调用第三方库
 *
 * PC寄存器：记录了方法之间的调用和执行的情况，类似于排版值日表，用来存储指向下一条指令的地址，也就是
 * 即将要执行的指令代码，它是当前线程所执行的字节码的行号指示器。
 *
 * @author wcx
 * @version 1.0
 */
public class NativeDemo02 {
    public static void main(String[] args) {
        // Exception in thread "main" java.lang.IllegalThreadStateException
        Thread t = new Thread();
        t.start();
        t.start();
    }
}
