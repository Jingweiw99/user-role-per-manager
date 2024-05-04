package com.wjw.pojo.vo;

import java.io.Serializable;
import java.util.List;

// 支持转换为字节流，在http中传输
public class UpdateUser implements Serializable {
    private Integer id; // 要修改用户的id
    private String username; // 用户名称
    private String password; // 密码
    private String email; // 邮箱
    private String remark; // 备注
    private List<String> roleIds; // 更新用户包含了多个角色

    @Override
    public String toString() {
        return "UpdateUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", remark='" + remark + '\'' +
                ", roleIds=" + roleIds +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<String> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<String> roleIds) {
        this.roleIds = roleIds;
    }
}
