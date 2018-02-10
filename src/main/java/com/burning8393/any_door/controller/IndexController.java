package com.burning8393.any_door.controller;

import com.burning8393.any_door.domain.User;
import com.burning8393.any_door.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public ModelAndView index(@ModelAttribute User user) {
        ModelAndView view = new ModelAndView();
        List<User> list = null;
        list = userService.getUserList(user);
        view.addObject(list);
        view.setViewName("index");
        return view;
    }

    @RequestMapping(value = "/user/enroll", method = RequestMethod.GET)
    public String enroll() {
        return "enroll";
    }

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public String checkList() {
        return "check_list";
    }
}
