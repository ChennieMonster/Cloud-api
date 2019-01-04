package com.cloud.api.dto;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

public class RoleAuthDTO implements Serializable {

    private static final long serialVersionUID = 3910254092700005669L;

    private String uuid;
    private String roleId;
    private String moduleName;
    private String actionAuth;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getActionAuth() {
        return actionAuth;
    }

    public void setActionAuth(String actionAuth) {
        this.actionAuth = actionAuth;
    }

    @Override
    public String toString() {
        return "RoleAuthDTO{" +
                "uuid=" + uuid +
                ", roleId=" + roleId +
                ", moduleName=" + moduleName +
                ", actionAuth=" + actionAuth +
                '}';
    }
}
