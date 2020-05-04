package com.jxkj.lambda;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
public class LambdaTestDemo {

    public static void main(String[] args) {
        System.out.println(Foo.mul(5, 5));
        Foo foo = () -> {
            System.out.println("hello");
        };
        foo.sayHello();
        System.out.println(foo.add(1, 2));
    }
}

@FunctionalInterface
interface Foo {

    void sayHello();

    default int add(int x, int y) {
        return x + y;
    }

    static int mul(int x, int y) {
        return x * y;
    }
}
