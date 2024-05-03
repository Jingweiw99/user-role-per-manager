package com.wjw.service.impl;

import com.wjw.dao.UserMapper;
import com.wjw.pojo.po.User;
import com.wjw.pojo.vo.QueryPageBean;
import com.wjw.service.UserService;
import com.wjw.utils.SqlSessionUtil;
import com.wjw.vo.PageResult;
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

    @Override
    public PageResult selectByPage(QueryPageBean queryPageBean) {
        SqlSession session = SqlSessionUtil.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        List<User> list = mapper.findUserByPage(queryPageBean);
        Long total = mapper.findUserTotal();
        PageResult pageResult = new PageResult(total, list);
        session.close();
        return pageResult;
    }
}
