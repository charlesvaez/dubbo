package com.hgsoft.springboot.dubbo.mybatis.common.sharding;

import com.hgsoft.springboot.dubbo.mybatis.common.entity.UserModel;
import lombok.Data;

import java.io.Serializable;

@Data
public class ShardingUserModel extends UserModel implements Serializable {

}
