package com.wjw.service;

import com.wjw.pojo.po.User;
import com.wjw.pojo.vo.QueryPageBean;
import com.wjw.pojo.vo.PageResult;

import java.util.List;

public interface UserService {
    // 找到所有用户，test使用
    List<User> findAllUser();
    /*
    分页条件查询用户表和角色标的信息
     */
    PageResult selectByPage(QueryPageBean queryPageBean);
}
