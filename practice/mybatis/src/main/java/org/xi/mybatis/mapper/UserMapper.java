package org.xi.mybatis.mapper;

import org.xi.mybatis.model.User;

import java.util.List;

public interface UserMapper {

    User getById(Integer id);

    List<User> selectAll();
}
