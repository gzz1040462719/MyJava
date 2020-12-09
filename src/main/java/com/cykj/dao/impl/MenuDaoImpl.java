package com.cykj.dao.impl;

import com.cykj.bean.Jurisdiction;
import com.cykj.bean.Menu;
import com.cykj.dao.MenuDao;
import com.cykj.mapper.MenuMapper;
import com.cykj.myuitl.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.math.BigDecimal;
import java.util.List;

public class MenuDaoImpl implements MenuDao {

    //根据父id查询子菜单
    @Override
    public List<Menu> menuByPid(int pid) {
        SqlSession session = MybatisUtil.getInstance().getSession();
        MenuMapper mapper = session.getMapper(MenuMapper.class);
        List<Menu> menus = mapper.menuByPid(pid);
        MybatisUtil.getInstance().close(session);
        return menus;
    }

    @Override
    public List<Jurisdiction> JurisdictionByRole(BigDecimal role) {
        SqlSession session = MybatisUtil.getInstance().getSession();
        MenuMapper mapper = session.getMapper(MenuMapper.class);
        List<Jurisdiction> menus = mapper.JurisdictionByRole(role);
        MybatisUtil.getInstance().close(session);
        return menus;
    }
}
