package com.wjw.pojo.po;

import java.util.HashSet;
import java.util.Set;

public class Role {
    private Integer id;
    private String name;
    private String keyword;
    private String description;
    private Set<User> users = new HashSet<>(0);
    private Set<Permission> permissions = new HashSet<>(0);

    public Role() {
    }

    public Role(String name, String keyword) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", keyword='" + keyword + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
