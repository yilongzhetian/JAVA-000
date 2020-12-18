package com.ylzt.geekbang.lesson09.work1.rpcfx.provider;


import com.ylzt.geekbang.lesson09.work1.rpcfx.api.User;
import com.ylzt.geekbang.lesson09.work1.rpcfx.api.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public User findById(int id) {
        return new User(id, "KK" + System.currentTimeMillis());
    }
}
