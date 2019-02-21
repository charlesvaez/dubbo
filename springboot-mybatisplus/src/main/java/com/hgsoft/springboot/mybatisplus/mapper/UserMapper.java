package com.hgsoft.springboot.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hgsoft.springboot.mybatisplus.entity.User;
import com.hgsoft.springboot.mybatisplus.model.MyPage;
import com.hgsoft.springboot.mybatisplus.model.ParamSome;
import org.apache.ibatis.annotations.Param;

public interface  UserMapper  extends BaseMapper<User> {
    /**
     * 3.x 的 page 可以进行取值,多个入参记得加上注解
     * 自定义 page 类必须放在入参第一位
     * 返回值可以用 IPage<T> 接收 也可以使用入参的 MyPage<T> 接收
     * todo 目前使用注解会报错,写在 xml 里就没事
     *
     * @param myPage 自定义 page
     * @return 分页数据
     */
    MyPage<User> mySelectPage(@Param("pg") MyPage<User> myPage, @Param("ps") ParamSome paramSome);
}
