package com.furui.ydfr.entity;

import java.io.Serializable;
import java.util.Date;

public class UserRoleRelationEntity implements Serializable {
    private String id;

    private String roleId;

    private String userId;

    private Date createTime;

    private Date updaeTime;

    private Integer enable;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdaeTime() {
        return updaeTime;
    }

    public void setUpdaeTime(Date updaeTime) {
        this.updaeTime = updaeTime;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }
}