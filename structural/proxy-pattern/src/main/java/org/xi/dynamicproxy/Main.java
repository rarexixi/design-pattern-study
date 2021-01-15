package org.xi.dynamicproxy;

import org.xi.dynamicproxy.model.ConfigDetail;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        InvocationHandler handler = new DynamicProxy(ConfigService.class);
        ConfigService subject = (ConfigService) Proxy.newProxyInstance(ConfigService.class.getClassLoader(), new Class<?>[] {ConfigService.class}, handler);
        ConfigDetail ares_service = subject.getConfig("ares_service", 1);
        System.out.println(ares_service);
    }
}
