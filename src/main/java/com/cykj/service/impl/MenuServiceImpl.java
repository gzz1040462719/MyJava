package com.cykj.service.impl;

import com.cykj.bean.Jurisdiction;
import com.cykj.bean.Menu;
import com.cykj.dao.DocumentDao;
import com.cykj.dao.MenuDao;
import com.cykj.dao.impl.MenuDaoImpl;
import com.cykj.myuitl.ObjectFactory;
import com.cykj.service.MenuService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

public class MenuServiceImpl implements MenuService {

    MenuDao menuDao = (MenuDao) ObjectFactory.newInstance(MenuDaoImpl.class);

    //根据角色返回菜单
    @Override
    public HashMap<String,List<Menu>> initMenu(BigDecimal role) {
        //存放角色菜单
        HashMap<String,List<Menu>> map=new HashMap<>();
        //根据角色查询所持有的菜单
        List<Jurisdiction> jurisdictions = menuDao.JurisdictionByRole(role);
        List<Menu> menus = menuDao.menuByPid(0);
        //所有父级菜单
        for (int i = 0; i < menus.size(); i++) {
            //根据pid查询父菜单存放进map
            for (int j = 0; j < jurisdictions.size(); j++) {
                if (jurisdictions.get(j).getMenuId().equals(menus.get(i).getMenuId())){
                    List<Menu> menus1 = menuDao.menuByPid(menus.get(i).getMenuId().intValue());
                    menus1.add(0,menus.get(i));
                    map.put(menus.get(i).getMenuName(),menus1);
                }
            }
        }
        return map;
    }
}
