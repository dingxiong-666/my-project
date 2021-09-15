package com.dx.project.controller;

import com.dx.project.entity.User;
import com.dx.project.mapper.UserMapper;
import com.dx.project.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: dx
 * @CreateTime: 2021-09-14 10:34
 * @Description: 用户控制器
 */

@Controller
@SuppressWarnings("all")
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper dao;
    @PostMapping
    @ResponseBody
    @CrossOrigin(origins="*")
    public Result save(@RequestBody User user){//自动转换
        System.out.println(user);
        dao.insert(user);
        return Result.success();



    }
}
