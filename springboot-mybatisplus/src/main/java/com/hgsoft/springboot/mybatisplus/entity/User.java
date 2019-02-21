package com.hgsoft.springboot.mybatisplus.entity;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
//fluent 若为true，则getter和setter方法的方法名都是属性名，且setter方法返回当前对象。
//chain 若为true，则setter方法返回当前对象
//prefix 若为true，则getter和setter方法会忽视属性名的指定前缀（遵守驼峰命名）
//@Data
//@Accessors(prefix = "f")
//class User {
//	private Integer fId;
//	private String fName;
//
//	// 生成的getter和setter方法如下，方法体略
//	public Integer id(){}
//	public void id(Integer id){}
//	public String name(){}
//	public void name(String name){}
//}

@Accessors(chain = true)
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
