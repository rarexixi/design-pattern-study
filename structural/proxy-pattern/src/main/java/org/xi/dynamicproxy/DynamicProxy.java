package org.xi.dynamicproxy;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.xi.dynamicproxy.annotation.Get;
import org.xi.dynamicproxy.annotation.Param;
import org.xi.dynamicproxy.model.GetRequestTemplate;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicProxy implements InvocationHandler {

    private Map<Method, GetRequestTemplate> methodMap = new HashMap<>();

    public DynamicProxy(Class<?> type) {
        setMethodMap(type);
    }

    private void setMethodMap(Class<?> type) {
        for (Method method : type.getMethods()) {
            Get get = method.getAnnotation(Get.class);
            String url = get.url();
            List<String> params = new ArrayList<>();
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                Param annotation = parameter.getAnnotation(Param.class);
                params.add("".equals(annotation.value()) ? parameter.getName() : annotation.value());
            }

            GetRequestTemplate template = new GetRequestTemplate();
            template.setUrl(url);
            template.setParams(params);
            methodMap.put(method, template);
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        GetRequestTemplate template = methodMap.get(method);
        List<String> parameters = new ArrayList<>();
        int i = 0;
        for (String param : template.getParams()) {
            parameters.add(param + "=" + args[i++]);
        }

        String url = template.getUrl() + "?" + String.join("&", parameters);
        System.out.println(url);
        HttpGet httpGet = new HttpGet(url);

        HttpClient client = HttpClients.createDefault();
        HttpResponse response = client.execute(httpGet);
        String html = EntityUtils.toString(response.getEntity(), "UTF-8");
        System.out.println(html);
        return JSON.parseObject(html, method.getReturnType());
    }
}
