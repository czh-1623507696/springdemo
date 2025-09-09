package com.czh.lxy422.service.impl;

import com.czh.lxy422.dao.UserDao;
import com.czh.lxy422.pojo.User;
import com.czh.lxy422.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao ;
    @Override
    public List<User> findAll()
    {
        List<String> lines = userDao.findAll();
        List<User> userList = lines.stream().map(line -> {
            String[] apart = line.split(",");
            Integer id = Integer.parseInt(apart[0]);
            String username = apart[1];
            String password = apart[2];
            String name = apart[3];
            Integer age = Integer.parseInt(apart[4]);
            LocalDateTime updateTime = LocalDateTime.parse(apart[5], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            return new User(id,username,password,name,age,updateTime);
        }).collect(Collectors.toList());
        
        //返回数据（josn格式）
        return userList;
    }
}
