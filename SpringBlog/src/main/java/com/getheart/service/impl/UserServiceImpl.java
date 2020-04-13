package com.getheart.service.impl;

import com.getheart.dao.UserDao;
import com.getheart.entity.User;
import com.getheart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Json
 * @date 2020-31-12:12
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Override
    public User checkUser(String username, String password) {

        User user = userDao.findAllByUsernameAndAndPassword(username, password);
        return user;
    }
}
