package org.xi.mybatis.config;

import lombok.Data;
import org.xi.mybatis.model.MappedStatement;

import java.util.HashMap;
import java.util.Map;

@Data
public class Configuration {

    private String url;
    private String username;
    private String password;
    private String driver;

    private Map<String, MappedStatement> statementMap = new HashMap<>();
}
