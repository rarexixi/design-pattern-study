package org.xi.mybatis.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private Long id;
    private String username;
    private String password;
    private String realName;
    private String email;
    private String mobile;
}
