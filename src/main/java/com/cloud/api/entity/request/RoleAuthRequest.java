package com.cloud.api.entity.request;

public class RoleAuthRequest {
    private String roleId;
    private String moduleName;
    private String actionAuth;

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
}
