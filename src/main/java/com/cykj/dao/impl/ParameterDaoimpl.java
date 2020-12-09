package com.cykj.dao.impl;

import com.cykj.bean.Parameter;
import com.cykj.dao.ParameterDao;
import com.cykj.mapper.ParameterMapper;
import com.cykj.myuitl.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.math.BigDecimal;

public class ParameterDaoimpl implements ParameterDao {

    //根据id查找
    @Override
    public Parameter findById(BigDecimal parameterId) {
        SqlSession session = MybatisUtil.getInstance().getSession();
        ParameterMapper mapper = session.getMapper(ParameterMapper.class);
        Parameter parameter = mapper.findById(parameterId);
        MybatisUtil.getInstance().close(session);
        return parameter;
    }
    //修改单条
    @Override
    public int updateParameter(Parameter parameter) {
        SqlSession session = MybatisUtil.getInstance().getSession();
        ParameterMapper mapper = session.getMapper(ParameterMapper.class);
        int i = mapper.updateParameter(parameter);
        MybatisUtil.getInstance().close(session);
        return i;
    }
}
