package com.cykj.mapper;

import com.cykj.bean.Parameter;

import java.math.BigDecimal;

//参数
public interface ParameterMapper {

  //根据id查找
  Parameter findById(BigDecimal parameterId);
  //修改单条
  int updateParameter(Parameter parameter);
}
