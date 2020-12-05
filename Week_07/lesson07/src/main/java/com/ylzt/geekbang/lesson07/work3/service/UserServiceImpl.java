package com.ylzt.geekbang.lesson07.work3.service;

import com.ylzt.geekbang.lesson07.domain.User;
import com.ylzt.geekbang.lesson07.dto.UserDTO;
import com.ylzt.geekbang.lesson07.work2.annotation.TargetDataSource;
import com.ylzt.geekbang.lesson07.work2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @ClassName: UserServiceImpl
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/12/4 9:58 下午
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findUser(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public void insertUser(UserDTO dto) {
        User user=new User();
        user.setName(dto.getName());
        user.setPhone(dto.getPhone());
        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());
        userRepository.save(user);
    }
}
