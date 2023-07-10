package com.register.dao;

import com.register.model.po.UserInfo;
import com.register.model.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    List<UserInfo> getAllUser();

    List<UserInfo> getUserByKey(String key);

    int insertUser(User u);

    int updateUser(User u);
}
