package org.xi.dynamicproxyjavassist;

import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        // 代理工厂
        ProxyFactory proxyFactory = new ProxyFactory();
        // 设置需要创建子类的父类
        proxyFactory.setInterfaces(new Class[]{Subject.class});
        /*
         * 定义一个拦截器。在调用目标方法时，Javassist会回调MethodHandler接口方法拦截，
         * 来实现你自己的代理逻辑，
         * 类似于JDK中的InvocationHandler接口。
         */
        Class<?> proxyClass = proxyFactory.createClass();
        Subject subject = (Subject) proxyClass.newInstance();
        /*
         * self为由Javassist动态生成的代理类实例，
         *  thismethod为 当前要调用的方法
         *  proceed 为生成的代理类对方法的代理引用。
         *  Object[]为参数值列表，
         * 返回：从代理实例的方法调用返回的值。
         *
         * 其中，proceed.invoke(self, args);
         *
         * 调用代理类实例上的代理方法的父类方法（即实体类ConcreteClassNoInterface中对应的方法）
         */
        ((ProxyObject) subject).setHandler((self, method, proceed, methodArgs) -> {
            System.out.println("--------------------------------");
            System.out.println(self.getClass());
            System.out.println("代理类对方法的代理引用:" + method.getName());
            System.out.println("开启事务 -------");

            method.getAnnotations();
            Select annotation = method.getAnnotation(Select.class);

            System.out.println("提交事务 -------");
            return annotation == null ? null : annotation.value();
        });
        System.out.println(subject.hello("xi"));;
    }
}
