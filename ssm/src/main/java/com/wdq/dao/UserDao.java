package com.wdq.dao;

import com.wdq.domain.User;


import java.util.List;

/**
 * Created by wdq on 2018/3/27.
 */
public interface UserDao {
    void save(User user);
    List<User> queryList();
}
