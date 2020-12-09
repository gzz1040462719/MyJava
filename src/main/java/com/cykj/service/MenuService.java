package com.cykj.service;

import com.cykj.bean.Menu;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public interface MenuService {

    //根据角色返回菜单
    HashMap<String, List<Menu>> initMenu(BigDecimal role);
}
