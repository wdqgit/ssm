package com.wdq.service;

import com.wdq.dao.UserDao;
import com.wdq.domain.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by wdq on 2018/3/27.
 */
@Service
public class UserService {
    @Resource
    private UserDao userMapper;
    @Transactional
    public void save(User user) {
        userMapper.save(user);
    }

    public List<User> queryList(){
        return userMapper.queryList();
    }
}
