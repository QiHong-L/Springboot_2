package com.getheart.dao;

import com.getheart.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Json
 * @date 2020-31-12:14
 */
public interface UserDao extends JpaRepository<User,Long> {

    User findAllByUsernameAndAndPassword(String username,String password);
}
