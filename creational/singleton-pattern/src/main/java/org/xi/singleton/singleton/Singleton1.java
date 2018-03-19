package org.xi.singleton.singleton;

/**
 * 饿汉式
 * <p>
 * 是否 Lazy 初始化：否
 * 是否多线程安全：是
 * <p>
 * 优点：没有加锁，执行效率会提高。
 * 缺点：类加载时就初始化，浪费内存。
 */
public class Singleton1 {

    private static Singleton1 instance = new Singleton1();

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        return instance;
    }
}