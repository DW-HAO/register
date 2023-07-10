package com.register.service.impl;

import com.register.dao.LoginUserDao;
import com.register.dao.UserDao;
import com.register.model.pojo.LoginUser;
import com.register.service.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginUserServiceImpl implements LoginUserService {

    @Autowired
    private LoginUserDao loginUserDao;

    @Override
    public LoginUser getLoginUser(String lu) {
        return loginUserDao.getLoginUser(lu);
    }

    @Override
    public LoginUser getPermission(String lu) {
        return loginUserDao.getPermission(lu);
    }

    @Override
    public int addLoginUser(LoginUser lu) {
        return loginUserDao.addLoginUser(lu);
    }
}
