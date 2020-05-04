package com.jxkj.jvm;

/**
 * 功能描述：堆空间
 *
 * 堆空间逻辑上分为：新生区、养老区、永久存储区（java8之后叫元空间）
 * 新生区又分为：伊甸区（Eden）、幸存0区（Survivor 0 space）、幸存1区 （Survivor 1 space）
 * 伊甸区如果要满了： GC = YGC = 轻量级GC 触发后Gden基本被清空，剩下的一些就往幸存0区。
 * 如果经历多次的GC，还没被清除（经常使用的对象），则会进入养老区。
 *
 * 如果养老区满了，就会调用 Full GC = FGC进行清理，如果清理还是满的，就会报（java.lang.OutOfMemory）OOM异常，堆内存溢出
 *
 * 新生区：
 * s0 为 from    s1 为 to
 * 如果伊甸区满了，先调用GC，将伊甸区没有被回收的复制到from，将伊甸区全部清空；当第二次GC，将对Eden和From进行清空，幸存者移向To；
 * 然后这个 幸存着年龄（逃过GC的次数）+1，然后To区变为From区（谁空谁是to），交换15次后，会将该对象移至养老区
 * （由JVM参数MaxTenuringThresHold决定，这个参数默认值为15）
 *
 *
 * @author wcx
 * @version 1.0
 */
public class HeapDemo05 {
    public static void main(String[] args) {

    }
}
