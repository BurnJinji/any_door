package com.burning8393.any_door.service;

import com.burning8393.any_door.dao.UserMapper;
import com.burning8393.any_door.domain.User;
import com.burning8393.any_door.domain.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> getUserList(User user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (null != user.getId()) {
            criteria.andIdEqualTo(user.getId());
        }
        return userMapper.selectByExample(example);
    }
}
