package com.cykj.bean;

import java.math.BigDecimal;

public class Menu {

    private BigDecimal menuId;
    private String menuName;//菜单名
    private String menuUrl;//菜单地址
    private BigDecimal menuPid;//父菜单

    public Menu() {
    }

    public BigDecimal getMenuId() {
        return menuId;
    }

    public void setMenuId(BigDecimal menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public BigDecimal getMenuPid() {
        return menuPid;
    }

    public void setMenuPid(BigDecimal menuPid) {
        this.menuPid = menuPid;
    }
}
