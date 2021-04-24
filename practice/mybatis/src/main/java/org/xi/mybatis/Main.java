package org.xi.mybatis;

import org.xi.mybatis.mapper.UserMapper;
import org.xi.mybatis.session.SqlSession;
import org.xi.mybatis.session.SqlSessionFactory;

public class Main {
    public static void main(String[] args) {

        SqlSessionFactory factory = new SqlSessionFactory();
        SqlSession session = factory.openSession();

        UserMapper userMapper = session.getMapper(UserMapper.class);

        System.out.println(userMapper.getById(1));
        System.out.println(userMapper.selectAll());
    }
}
