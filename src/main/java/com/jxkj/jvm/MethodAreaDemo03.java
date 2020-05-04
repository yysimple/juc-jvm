package com.jxkj.jvm;

/**
 * 功能描述：方法区
 * 方法区，放的是类的结构信息（模板，类类型），放的就是类本身有的 （static）
 * 方法区本身只是一个规范，在不同虚拟机里面的实现是不同的，如永久代（permGen space）和元空间（Meta space）
 *
 * 方法区和堆一样，是各个线程共享的内存区域，他用于虚拟机加载的：类信息 + 普通常量 + 静态常量 + 编译期编译后的代码等
 *
 * @author wcx
 * @version 1.0
 */
public class MethodAreaDemo03 {
    public static void main(String[] args) {

    }

    public void sayHello() {

    }

    /**
     * 属于类本身，会被类装器加载到模板中
     */
    public static void sayHello02() {

    }
}
