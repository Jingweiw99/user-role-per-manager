package com.wjw.service.impl;

import com.wjw.dao.UserMapper;
import com.wjw.pojo.po.User;
import com.wjw.service.UserService;
import com.wjw.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserServiceImpl implements UserService {


    @Override
    public List<User> findAllUser() {
        SqlSession session = SqlSessionUtil.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> users = mapper.finAllUser();
        return users;
    }
}
