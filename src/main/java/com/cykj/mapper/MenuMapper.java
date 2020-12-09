package com.cykj.mapper;

import com.cykj.bean.Jurisdiction;
import com.cykj.bean.Menu;

import java.math.BigDecimal;
import java.util.List;

public interface MenuMapper {

    //根据父id查询子菜单
    List<Menu> menuByPid(int pid);

    //根据角色查询菜单
    List<Jurisdiction> JurisdictionByRole(BigDecimal role);
}
