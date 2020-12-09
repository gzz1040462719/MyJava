package com.cykj.service.impl;

import com.cykj.bean.Parameter;
import com.cykj.dao.DocumentDao;
import com.cykj.dao.ParameterDao;
import com.cykj.dao.UserDao;
import com.cykj.dao.impl.DocumentDaoimpl;
import com.cykj.dao.impl.ParameterDaoimpl;
import com.cykj.dao.impl.UserDaoimpl;
import com.cykj.myuitl.ObjectFactory;
import com.cykj.service.UserService;

import java.math.BigDecimal;

public class UserServiceimpl implements UserService {

    UserDao userDao = (UserDao) ObjectFactory.newInstance(UserDaoimpl.class);
    ParameterDao parameterDao = (ParameterDao) ObjectFactory.newInstance(ParameterDaoimpl.class);

    //积分奖励页面
    @Override
    public Parameter initScorePage() {
        return parameterDao.findById(new BigDecimal(8));
    }

    //修改注册奖励
    @Override
    public int updateScore(String score) {
        Parameter parameter = new Parameter();
        parameter.setParameterId(new BigDecimal(8));
        parameter.setParameterName(score);
        return parameterDao.updateParameter(parameter);
    }




}
