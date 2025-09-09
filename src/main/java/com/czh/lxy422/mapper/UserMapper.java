package com.czh.lxy422.mapper;

import com.czh.lxy422.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;
@Mapper
public interface UserMapper {
/*
* 查询全部
* */
    public List<User> findAll();
/*
* 根据id删除
* */

    public Integer deleteById(Integer id);
    /*
    * 根据用户信息查询
    * */
    @Select("select * from user where username=#{username} and password=#{password}")
    public User selectByuser(@Param("username") String username,@Param("password") String password);
    /*
    * 新增用户
    * */
    @Select("insert into user(username,password,name,age) values(#{username},#{password},#{name},#{age})")
    public Integer addUser(User user);
}