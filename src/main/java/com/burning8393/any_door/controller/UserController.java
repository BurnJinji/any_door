package com.burning8393.any_door.controller;

import com.burning8393.any_door.dao.UserMapper;
import com.burning8393.any_door.domain.User;
import com.burning8393.any_door.domain.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    /***
     * 根据用户id查看用户详情
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public User getDetail(@RequestParam(value = "id") String id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    /***
     * 统计当前有效用户总数
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "userCount", method = RequestMethod.GET)
    public long getUserCount() {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        return userMapper.countByExample(example);
    }
}
