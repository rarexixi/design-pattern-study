package org.xi.mybatis.session;

import org.xi.mybatis.config.Configuration;
import org.xi.mybatis.executor.DefaultExecutor;
import org.xi.mybatis.executor.Executor;
import org.xi.mybatis.model.MappedStatement;
import org.xi.mybatis.proxy.MapperProxy;

import java.lang.reflect.Proxy;
import java.util.List;

public class DefaultSqlSession implements SqlSession {

    private final Configuration conf;
    private Executor executor;

    public DefaultSqlSession(Configuration conf) {
        this.conf = conf;
        this.executor = new DefaultExecutor(conf);
    }

    @Override
    public <T> T selectOne(String statement, Object params) {
        List<T> list = selectList(statement, params);
        if (list == null || list.isEmpty()) {
            return null;
        }
        if (list.size() != 1) {
            throw new RuntimeException("结果不唯一");
        }
        return list.get(0);
    }

    @Override
    public <E> List<E> selectList(String statement, Object params) {
        MappedStatement mappedStatement = conf.getStatementMap().get(statement);
        return executor.query(mappedStatement, params);
    }

    @Override
    public <T> T getMapper(Class<T> mapperType) {
        MapperProxy mapperProxy = new MapperProxy(this);
        return (T) Proxy.newProxyInstance(mapperType.getClassLoader(), new Class[]{mapperType}, mapperProxy);
    }
}
