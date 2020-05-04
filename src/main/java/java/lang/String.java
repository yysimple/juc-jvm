package java.lang;

/**
 * 功能描述：双亲委派
 *
 * 当一个类接收到了类加载器请求，该发出请求的类加载器不会自己先去尝试加载这个类，而是将这个请求委派给父类去完成，
 * 所以，所有的加载请求都会传送到启动类加载器（BootStrap）进行加载，如果父类反馈自己无法完成此次加载
 * （就是在其加载路径下没有找到对应的class文件），子类加载器才会去尝试自己加载。
 *
 * 这样做的好处就是，不管是使用什么类加载器去加载String，都会先通过父加载器（Bootstrap）进行加载，这样能保证
 * 最后加载到的String对象是 同一个  对象
 *
 * 沙箱安全：JVM将不同的代码放在不同的域中，从而控制权限
 *
 * @author wcx
 * @version 1.0
 */
public class String {
    public static void main(String[] args) {
        /**
         * 错误: 在类 java.lang.String 中找不到 main 方法, 请将 main 方法定义为:
         *    public static void main(String[] args)
         * 否则 JavaFX 应用程序类必须扩展javafx.application.Application
         */
        System.out.println("我是自己定义的类...");

    }
}
