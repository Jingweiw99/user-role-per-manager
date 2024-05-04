package com.wjw.dao;

import com.wjw.pojo.po.Role;
import com.wjw.pojo.po.User;
import com.wjw.pojo.vo.AddUser;
import com.wjw.pojo.vo.QueryPageBean;
import com.wjw.pojo.vo.UpdateUser;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Set;

public interface UserMapper {
    @Select("select * from t_user")
    List<User> finAllUser();

    List<User> findUserByPage(QueryPageBean queryPageBean);

    @Select("select count(*) from t_user")
    Long findUserTotal();


    @Update("update t_user set username = #{username},password=#{password},email = #{email} where id = #{id}")
    void updateUser(UpdateUser updateUser);

    @Delete("delete from t_user_role where user_id = #{id}")
    void deleteRoleByUid(Integer id);

    /**
     * 向中间表中添加用户id和对应多个角色id
     *
     * @param id
     * @param roleIds
     */
    void addRoleByUid(@Param("uid") Integer id, @Param("rids") List<String> roleIds);

    // 用户的角色可以在创建时候给，也可以在修改的时候添加
    @Insert("insert into t_user(username,password,email) values (#{username},#{password},#{email})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void addUser(AddUser addUser);

    void insertRids(@Param("uid") Integer id, @Param("rids") Set<String> roleIds);
}
