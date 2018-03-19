package org.xi.singleton.singleton;

/**
 * 懒汉式，线程安全
 * <p>
 * 是否 Lazy 初始化：是
 * 是否多线程安全：是
 * <p>
 * 优点：第一次调用才初始化，避免内存浪费。
 * 缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率。
 */
public class Singleton2 {

    private static Singleton2 instance;

    private Singleton2() {
    }

    public static synchronized Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}


