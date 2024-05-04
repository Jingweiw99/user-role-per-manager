package com.wjw.service.impl;

import com.wjw.dao.UserMapper;
import com.wjw.pojo.po.Role;
import com.wjw.pojo.po.User;
import com.wjw.pojo.vo.AddUser;
import com.wjw.pojo.vo.QueryPageBean;
import com.wjw.pojo.vo.UpdateUser;
import com.wjw.service.UserService;
import com.wjw.utils.SqlSessionUtil;
import com.wjw.pojo.vo.PageResult;
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


    @Override
    public void update(UpdateUser updateUser) {
        SqlSession session = SqlSessionUtil.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        // 需要更新用户表，用户角色表（删除之前的，添加上后面新增）
        mapper.updateUser(updateUser);
        mapper.deleteRoleByUid(updateUser.getId());
        mapper.addRoleByUid(updateUser.getId(), updateUser.getRoleIds());
        // 这里可以用事务
        session.close();
    }

    @Override
    public void addUser(AddUser addUser) {
        SqlSession session = SqlSessionUtil.getSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.addUser(addUser);
        Integer id = addUser.getId();
        mapper.insertRids(id,addUser.getRoleIds());
    }

}
