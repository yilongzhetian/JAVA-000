package com.ylzt.geekbang.lesson07.work2.controller;

import com.ylzt.geekbang.lesson07.domain.User;
import com.ylzt.geekbang.lesson07.dto.UserDTO;
import com.ylzt.geekbang.lesson07.work2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: UserController
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/12/5 11:07 下午
 **/
@RequestMapping(value = "/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping(value = "find")
    public User findUser(Long id){
        User user= userService.findUser(id);
        return  user;
    }

    @PostMapping(value = "/save")
    public String insertUser(@RequestBody UserDTO dto){
        userService.insertUser(dto);
        return "success";
    }



}
