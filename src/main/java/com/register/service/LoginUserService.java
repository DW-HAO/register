package com.register.service;

import com.register.model.pojo.LoginUser;

public interface LoginUserService {

    LoginUser getLoginUser(String lu);

    LoginUser getPermission(String lu);

    int addLoginUser(LoginUser lu);
}
