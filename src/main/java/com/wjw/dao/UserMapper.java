package com.wjw.dao;

import com.wjw.pojo.po.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
    @Select("select * from t_user")
    List<User> finAllUser();
}
