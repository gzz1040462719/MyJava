package com.cykj.service;

import com.cykj.bean.Parameter;

public interface UserService {

    //积分奖励页面
    public Parameter initScorePage();

    //修改注册奖励
    public int updateScore(String score);

}
