package com.wjw.service.impl;

import com.wjw.dao.RoleMapper;
import com.wjw.pojo.po.Role;
import com.wjw.service.RoleService;
import com.wjw.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RoleServiceImpl implements RoleService {

    @Override
    public List<Role> findAllRoles() {
        SqlSession session = SqlSessionUtil.getSession();
        RoleMapper mapper = session.getMapper(RoleMapper.class);
        List<Role> roles= mapper.findAllRoles();
        return roles;
    }
}
