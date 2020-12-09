package com.cykj.bean;

import java.math.BigDecimal;

//权限表实体类
public class Jurisdiction {

    private BigDecimal JurisdictionId;
    private BigDecimal role;//角色
    private BigDecimal menuId;//菜单id

    public Jurisdiction() {
    }

    public BigDecimal getJurisdictionId() {
        return JurisdictionId;
    }

    public void setJurisdictionId(BigDecimal jurisdictionId) {
        JurisdictionId = jurisdictionId;
    }

    public BigDecimal getRole() {
        return role;
    }

    public void setRole(BigDecimal role) {
        this.role = role;
    }

    public BigDecimal getMenuId() {
        return menuId;
    }

    public void setMenuId(BigDecimal menuId) {
        this.menuId = menuId;
    }
}
