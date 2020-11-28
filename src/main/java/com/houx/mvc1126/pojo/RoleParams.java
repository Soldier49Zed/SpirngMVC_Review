package com.houx.mvc1126.pojo;

/**
 * @Author: HouX
 * @Date: 2020/11/26
 * @Description:
 */
public class RoleParams {

    private String roleName;
    private String note;

    private PageParams pageParams = null;

    public PageParams getPageParams() {
        return pageParams;
    }

    public void setPageParams(PageParams pageParams) {
        this.pageParams = pageParams;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
