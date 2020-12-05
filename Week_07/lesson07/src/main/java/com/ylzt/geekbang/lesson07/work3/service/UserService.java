package com.ylzt.geekbang.lesson07.work3.service;

import com.ylzt.geekbang.lesson07.domain.User;
import com.ylzt.geekbang.lesson07.dto.UserDTO;

/**
 * @ClassName: UserService
 * @Description: TODO
 * @Author: liwenlong
 * @Date: 2020/12/3 1:07 上午
 **/

public interface UserService {

       User findUser(Long id);


       void insertUser(UserDTO dto);
}
