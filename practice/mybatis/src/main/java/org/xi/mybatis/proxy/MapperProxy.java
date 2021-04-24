package org.xi.mybatis.proxy;

import org.xi.mybatis.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Collection;

public class MapperProxy implements InvocationHandler {

    private SqlSession sqlSession;

    public MapperProxy(SqlSession sqlSession) {
        super();
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String sourceId = method.getDeclaringClass().getName() + "." + method.getName();
        if (Collection.class.isAssignableFrom(method.getReturnType())) {
            return sqlSession.selectList(sourceId, args == null ? null : args[0]);
        } else {
            return sqlSession.selectOne(sourceId, args[0]);
        }
    }
}
