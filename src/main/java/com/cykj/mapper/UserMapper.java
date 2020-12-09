package com.cykj.mapper;

import com.cykj.bean.Document;
import com.cykj.bean.User;

import java.util.HashMap;
import java.util.List;

public interface UserMapper {

    int  addUser(User user);

    int deleteUserById(User user);
    int updateUser(User user);
    //条件查询所有用户
    List<User> findAll(HashMap<String, Object> condition);
    //条件查询所有用户总数
    public int UserTotal(HashMap<String, Object> condition);

    User login(String acc, String pwd);

    List<User> allUser();

    List<Document> documentAll();

    List<User> userByDocument();
}
