package org.xi.mybatis.model;

import lombok.Data;

@Data
public class MappedStatement {

    private String namespace;
    private String sourceId;
    private String resultType;
    private String sql;
}
