package com.cykj.dao;

import com.cykj.bean.Parameter;

import java.math.BigDecimal;

public interface ParameterDao {

    //根据id查找
    Parameter findById(BigDecimal parameterId);
    //修改单条
    int updateParameter(Parameter parameter);


}
