package org.xi.singleton.singleton;

/**
 * 双检锁/双重校验锁
 * <p>
 * 是否 Lazy 初始化：是
 * 是否多线程安全：是
 * <p>
 * 这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
 */
public class Singleton3 {

    private volatile static Singleton3 singleton;

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        if (singleton == null) {
            synchronized (Singleton3.class) {
                if (singleton == null) {
                    singleton = new Singleton3();
                }
            }
        }
        return singleton;
    }
}
