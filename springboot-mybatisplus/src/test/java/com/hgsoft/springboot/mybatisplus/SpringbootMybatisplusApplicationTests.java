package com.hgsoft.springboot.mybatisplus;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.hgsoft.springboot.mybatisplus.entity.User;
import com.hgsoft.springboot.mybatisplus.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootMybatisplusApplicationTests {
    @Resource
    private UserMapper userMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    @Test
    //If your test is @Transactional, it rolls back the transaction at the end of each test method by default.
    @Transactional
//    @Rollback
//    @Commit
    public void aInsert() {
        User user = new User();
        user.setName("小羊");
        user.setAge(4);
        user.setEmail("abc@mp.com");
        Assert.assertTrue(userMapper.insert(user) > 0);
        // 成功直接拿会写的 ID
        System.err.println("\n插入成功 ID 为：" + user.getId());
    }


    @Test
    public void bDelete() {
        Assert.assertTrue(userMapper.deleteById(3L) > 0);
        Assert.assertTrue(userMapper.delete(new QueryWrapper<User>()
                .lambda().eq(User::getName, "Sandy")) > 0);
    }


    @Test
    public void cUpdate() {
//        Assert.assertTrue(userMapper.updateById(new User().setId(1L).setEmail("ab@c.c")) > 0);
        Assert.assertTrue(userMapper.update(new User().setName("mp"),
                new UpdateWrapper<User>().lambda()
                        .set(User::getAge, 3)
                        .eq(User::getId, 2)) > 0);
    }


    @Test
    public void dSelect() {
        Assert.assertEquals("ab@c.c", userMapper.selectById(1L).getEmail());
        User user = userMapper.selectOne(new QueryWrapper<User>().lambda().eq(User::getId, 2));
        Assert.assertEquals("mp", user.getName());
        Assert.assertTrue(3 == user.getAge());
    }

    @Test
    public void orderBy() {
        QueryWrapper<User> ew = new QueryWrapper<>();
        ew.orderByAsc("age");
        Assert.assertTrue(!userMapper.selectList(ew).isEmpty());
    }

    @Test
    public void orderByLambda() {
        LambdaQueryWrapper<User> lw = new LambdaQueryWrapper<>();
        lw.orderByAsc(User::getAge);
        Assert.assertTrue(!userMapper.selectList(lw).isEmpty());
    }

}
