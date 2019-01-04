package com.cloud.api.entity.request;

import com.cloud.api.entity.GetListParamElement;

import javax.validation.constraints.Size;
import java.util.List;
import java.util.Map;

public class RoleRequest {

    private String uuid;

    @Size(max = 32, message = "{RoleRequest.roleName.length}")
    private String roleName;

    private String roleType;

    private String remark;

    private List<RoleAuthRequest> authList;

    private String delRoleids;

    private List<GetListParamElement> sort;

    private List<GetListParamElement> filter;

    private Integer currentPage;

    private Integer pageSize;

    private List<Map<String, String>> parameters;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<RoleAuthRequest> getAuthList() {
        return authList;
    }

    public void setAuthList(List<RoleAuthRequest> authList) {
        this.authList = authList;
    }

    public List<GetListParamElement> getSort() {
        return sort;
    }

    public void setSort(List<GetListParamElement> sort) {
        this.sort = sort;
    }

    public List<GetListParamElement> getFilter() {
        return filter;
    }

    public void setFilter(List<GetListParamElement> filter) {
        this.filter = filter;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<Map<String, String>> getParameters() {
        return parameters;
    }

    public void setParameters(List<Map<String, String>> parameters) {
        this.parameters = parameters;
    }

    public String getDelRoleids() {
        return delRoleids;
    }

    public void setDelRoleids(String delRoleids) {
        this.delRoleids = delRoleids;
    }
}
