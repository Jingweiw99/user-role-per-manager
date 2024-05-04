package com.wjw.pojo.vo;

import java.io.Serializable;
import java.util.Set;

public class AddUser implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String remark;
    private Set<String> roleIds; // 用户对应多个角色id

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

    public Set<String> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(Set<String> roleIds) {
        this.roleIds = roleIds;
    }

    @Override
    public String toString() {
        return "AddUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", remark='" + remark + '\'' +
                ", roleIds=" + roleIds +
                '}';
    }
}
