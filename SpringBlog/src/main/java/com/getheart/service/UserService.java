package com.getheart.service;

import com.getheart.entity.User;

/**
 * @author Json
 * @date 2020-31-12:11
 */
public interface UserService {

    User checkUser(String username,String password);
}
