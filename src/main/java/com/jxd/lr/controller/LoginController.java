package com.jxd.lr.controller;

import com.jxd.lr.model.User;
import com.jxd.lr.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName LRController
 * @Description TODO
 * @Author liushijing
 * @Date 2023/1/23
 * @Version 1.0
 */
@RestController
public class LoginController {

    @Autowired
    private IUserService userService;
    @RequestMapping("/login")
    public String login(@RequestBody User user) {
        return userService.login(user);

    }
}
