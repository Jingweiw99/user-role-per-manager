package com.wjw.service;

import com.wjw.pojo.po.User;

import java.util.List;

public interface UserService {
    // 找到所有用户，test使用
    List<User> findAllUser();
}
