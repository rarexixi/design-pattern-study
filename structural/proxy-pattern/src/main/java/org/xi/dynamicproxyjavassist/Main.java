package org.xi.dynamicproxyjavassist;

import com.alibaba.fastjson.JSON;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.xi.dynamicproxyjavassist.annotation.Get;
import org.xi.dynamicproxyjavassist.annotation.Param;
import org.xi.dynamicproxyjavassist.model.GetRequestTemplate;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        // 代理工厂
        ProxyFactory proxyFactory = new ProxyFactory();
        // 设置需要创建子类的父类
        proxyFactory.setInterfaces(new Class[]{ConfigService.class});
        /*
         * 定义一个拦截器。在调用目标方法时，Javassist会回调MethodHandler接口方法拦截，
         * 来实现你自己的代理逻辑，
         * 类似于JDK中的InvocationHandler接口。
         */
        Class<?> proxyClass = proxyFactory.createClass();
        ConfigService configService = (ConfigService) proxyClass.newInstance();
        /*
         * self为由Javassist动态生成的代理类实例，
         * thismethod为 当前要调用的方法
         * proceed 为生成的代理类对方法的代理引用。
         * Object[]为参数值列表，
         * 返回：从代理实例的方法调用返回的值。
         *
         * 其中，proceed.invoke(self, args);
         *
         * 调用代理类实例上的代理方法的父类方法（即实体类ConcreteClassNoInterface中对应的方法）
         */
        ((ProxyObject) configService).setHandler((self, method, proceed, methodArgs) -> {
            System.out.println("--------------------------------");
            System.out.println(self.getClass());
            System.out.println("代理类对方法的代理引用:" + method.getName());
            System.out.println("开启事务 -------");

            List<String> params = new ArrayList<>();
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                Param annotation = parameter.getAnnotation(Param.class);
                params.add("".equals(annotation.value()) ? parameter.getName() : annotation.value());
            }

            GetRequestTemplate template = new GetRequestTemplate();
            Get get = method.getAnnotation(Get.class);
            template.setUrl(get.url());
            template.setParams(params);

            List<String> queryParams = new ArrayList<>();
            int i = 0;
            for (String param : template.getParams()) {
                queryParams.add(param + "=" + methodArgs[i++]);
            }

            String url = template.getUrl() + "?" + String.join("&", queryParams);
            System.out.println(url);
            HttpGet httpGet = new HttpGet(url);

            HttpClient client = HttpClients.createDefault();
            HttpResponse response = client.execute(httpGet);
            String html = EntityUtils.toString(response.getEntity(), "UTF-8");
            System.out.println(html);
            return JSON.parseObject(html, method.getReturnType());
        });
        System.out.println(configService.getConfig("ares_service", 1));;
    }
}
