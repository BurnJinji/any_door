package com.burning8393.any_door.controller;

import com.burning8393.any_door.dao.UserMapper;
import com.burning8393.any_door.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    private UserMapper userMapper;
    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "user")
    public User user(@RequestParam(value = "id") String id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }
}
