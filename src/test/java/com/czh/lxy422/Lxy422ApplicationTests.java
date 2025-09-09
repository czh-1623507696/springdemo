package com.czh.lxy422;

import com.czh.lxy422.mapper.UserMapper;
import com.czh.lxy422.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Lxy422ApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindAll() {
        List<User> userList = userMapper.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }



    @Test
    public void testdeleteByid() {
        System.out.println("删除前检查记录是否存在");
        User user = userMapper.selectByuser("xiaoqiao","123456");
        System.out.println("要删除的用户：" + user);

        Integer row = userMapper.deleteById(5);
        System.out.println("删除影响的记录数是：" + row);


    }
    @Test
    public void testinsert(){
        User user = new User();
        user.setId(10);
        user.setUsername("admin");
        user.setPassword("123456");
        user.setName("管理员");
        user.setAge(30);
        userMapper.addUser(user);
    }

}