package com.czh.lxy422.dao.impl;

import cn.hutool.core.io.IoUtil;
import com.czh.lxy422.dao.UserDao;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
@Component
public class UserDaoImpl implements UserDao {
    @Override
    public List<String> findAll() {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("user.txt");
        ArrayList<String> lines = IoUtil.readUtf8Lines(in, new ArrayList<>());
        return lines;//解析文件
    }
}
