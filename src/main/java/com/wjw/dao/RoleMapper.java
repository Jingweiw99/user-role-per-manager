package com.wjw.dao;

import com.wjw.pojo.po.Role;
import com.wjw.pojo.vo.UpdateUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface RoleMapper {
    @Select("select * from t_role")
    List<Role> findAllRoles();
}
