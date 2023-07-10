package com.register.dao;

import com.register.model.pojo.LoginUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginUserDao {

    LoginUser getLoginUser(String lu);

    LoginUser getPermission(String lu);

    int addLoginUser(LoginUser lu);
}
