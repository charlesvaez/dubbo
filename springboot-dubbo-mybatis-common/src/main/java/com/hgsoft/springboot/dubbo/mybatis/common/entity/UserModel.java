package com.hgsoft.springboot.dubbo.mybatis.common.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserModel implements Serializable {
    private Long id;
    private String name;
    private String pwd;
    private Date createTime;

}
