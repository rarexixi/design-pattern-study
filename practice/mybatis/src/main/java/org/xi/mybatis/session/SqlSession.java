package org.xi.mybatis.session;

import java.util.List;

public interface SqlSession {

    <T> T selectOne(String sql, Object params);

    <E> List<E> selectList(String sql, Object params);

    <T> T getMapper(Class<T> mapperType);
}
