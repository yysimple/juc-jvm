package com.jxkj.jvm;

import java.util.Random;

/**
 * 功能描述：
 * 在IDEA中配置：-Xms1024m -Xmx1024m -XX:+PrintGCDetails 可以将JVM的内存和最大内存设置成一样这里是1G，然后后面那个功能是打印日志
 *
 * GC是什么（分代收集算法）：没有最好的算法，只有最适合的
 * 次数上频繁收集Young区（使用复制算法）
 * 次数上较少收集的Old区（使用标记算法）
 * 基本不动的元空间
 *
 * 年轻代：因为存活率低，所以可以使用复制法是速度最快的。复制算法内存利用率不高的问题，通过hotspot中两个survivor的设计得到缓解。
 * 老年代：里面对象的存活率较高，所以可以采用 标记清除和标记压缩混合使用。
 *
 * GC的四大算法：引用计数法、复制算法（copying）、标记清除（Mark-Sweep）、标记压缩（Mark-compact）
 * 引用计数法：
 *  原理：给每个对个对象加上数字标识，每次对象被引用时+1,0既是没有被引用
 *  缺点：每次对对象进行赋值时需要维护引用计数器，且计数器本身也有点消耗，较难处理循环引用
 *
 * 复制算法（copying）：
 *  原理：就是将Eden+from区全部复制到to区，to和from交换，这样可以避免内存碎片化
 *  缺点：需要耗费大量空间用于等待复制，特别耗内存，需要在eden区存活率较低的情况下使用
 *
 * 标记清除法：
 *  原理：进行第一次扫描，将所有需要GC清除的对象进行标记，然后清除对象，在进行第二次扫描，将这些标记全部清理，在让应用程序恢复运行
 *  缺点：需要进行两次扫描，虽然不需要两份空间，但是会造成内存碎片，效率低（递归与全堆对象遍历），GC时应用程序会暂停，用户体验低
 *
 * 标记压缩法：
 *  原理：与标记清除法前面是一样的，就是在处理完之后会去整理空间，将幸存的对象移至一边，将碎片空间整理到一起
 *  缺点：耗费时间
 *
 *
 *
 * @author wcx
 * @version 1.0
 */
public class HeapFix0602 {
    public static void main(String[] args) {
        // byte[] bytes = new byte[40 * 1024 * 1024];
        // java.lang.OutOfMemoryError: Java heap space  堆溢出
        String str = "www.wcx412.xyz";
        while (true) {
            str += str + new Random().nextInt(8888888) + new Random().nextInt(9999999);
        }

    }
}
