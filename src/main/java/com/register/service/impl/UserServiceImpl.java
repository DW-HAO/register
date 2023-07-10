package com.register.service.impl;

import com.register.dao.UserDao;
import com.register.model.po.UserInfo;
import com.register.model.pojo.LoginUser;
import com.register.model.pojo.User;
import com.register.service.LoginUserService;
import com.register.service.UserService;
import com.register.utils.SaltConstrutor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private LoginUserService loginUserService;

    @Override
    public List<UserInfo> getAllUser() {
        List<UserInfo> allUser = userDao.getAllUser();
        return allUser;
    }

    @Override
    public List<UserInfo> getUserByKey(String key) {
        return userDao.getUserByKey(key);
    }

    @Override
    public int insertUser(User u) {
        userDao.insertUser(u);
        LoginUser lu = new LoginUser();
        SaltConstrutor saltConstrutor = new SaltConstrutor();
        int salt = saltConstrutor.nextSalt();
        Md5Hash md5Hash = new Md5Hash("0000", "" + salt, 5);
        lu.setLoginUser(u.getName());
        lu.setPassword(md5Hash.toString());
        lu.setSalt("" + salt);
        loginUserService.addLoginUser(lu);
        return 0;
    }

    @Override
    public int updateUser(User u) {
        userDao.updateUser(u);
        return 0;
    }
}
