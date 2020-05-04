package com.jxkj.jvm;

/**
 * 功能描述：类装载器
 * 有三种：
 * 1. BootStrap：启动类加载器，C++编写的，java的根基 rt.jar （Runtime）
 * 2. Extension：扩展类加载器 Java 用于java扩展的 jar
 * 3. AppClassLoader：应用程序类加载器，也叫系统类加载器，加载当前应用的classpath的所有类
 *
 * myObjectDemo01.getClass()： 得到的使其类类型 Class Class<T>，然后类加载器就会去加载这个类类型
 *
 *
 * @author wcx
 * @version 1.0
 */
public class MyObjectDemo01 {
    public static void main(String[] args) {
        Object object = new Object();
        // System.out.println(object.getClass().getClassLoader().getParent().getParent());
        // System.out.println(object.getClass().getClassLoader().getParent());
        // 这是属于java自己的类，是使用BootStrap加载器进行加载的，所以上面两个写出时会报空指针异常找不到其父类  null
        System.out.println(object.getClass().getClassLoader());

        MyObjectDemo01 myObjectDemo01 = new MyObjectDemo01();

        //  null
        System.out.println(myObjectDemo01.getClass().getClassLoader().getParent().getParent());
        // sun.misc.Launcher$ExtClassLoader@3a71f4dd
        System.out.println(myObjectDemo01.getClass().getClassLoader().getParent());
        // sun.misc.Launcher$AppClassLoader@18b4aac2 自己定义的类，走的是AppClassLoader加载器
        // sun.misc.Launcher JVM的入口程序
        System.out.println(myObjectDemo01.getClass().getClassLoader());
    }
}
