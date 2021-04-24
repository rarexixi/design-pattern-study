package org.xi.mybatis.executor;

import org.xi.mybatis.model.MappedStatement;

import java.util.List;

public interface Executor {

    <E> List<E> query(MappedStatement mappedStatement, Object params);
}
