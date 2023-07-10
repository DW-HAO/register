package com.register.service;

import com.register.model.po.UserInfo;
import com.register.model.pojo.User;

import java.util.List;

public interface UserService {

    List<UserInfo> getAllUser();

    List<UserInfo> getUserByKey(String key);

    int insertUser(User u);

    int updateUser(User u);
}
